layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    /**
     * 加载数据表格
     */
    var tableIns = table.render({
        id:'saleChanceTable'
        // 容器元素的ID属性值
        ,elem: '#saleChanceList'
        // 容器的高度 full-差值
        ,height: 'full-125'
        // 单元格最小的宽度
        ,cellMinWidth:95
        // 访问数据的URL（后台的数据接口）
        ,url: ctx + '/sale_chance/list'
        // 开启分页
        ,page: true
        // 默认每页显示的数量
        ,limit:10
        // 每页页数的可选项
        ,limits:[10,20,30,40,50]
        // 开启头部工具栏
        ,toolbar:'#toolbarDemo'
        // 表头
        ,cols: [[
            // field：要求field属性值与返回的数据中对应的属性字段名一致
            // title：设置列的标题
            // sort：是否允许排序（默认：false）
            // fixed：固定列
            {type:'checkbox', fixed:'center'}
            ,{field: 'id', title: '编号',  sort: true, fixed: 'left'}
            ,{field: 'chanceSource', title: '机会来源', align:'center'}
            ,{field: 'customerName', title: '客户名称', align:'center'}
            ,{field: 'cgjl', title: '成功几率', align:'center'}
            ,{field: 'overview', title: '概要', align:'center'}
            ,{field: 'linkMan', title: '联系人', align:'center'}
            ,{field: 'linkPhone', title: '联系号码', align:'center'}
            ,{field: 'description', title: '描述', align:'center'}
            ,{field: 'createMan', title: '创建人', align:'center'}
            ,{field: 'uname', title: '分配人', align:'center'}
            ,{field: 'assignTime', title: '分配时间', align:'center'}
            ,{field: 'createDate', title: '创建时间', align:'center'}
            ,{field: 'updateDate', title: '修改时间', align:'center'}
            ,{field: 'state', title: '分配状态', align:'center',templet: function (d) {
                // 调用函数，返回格式化的结果
                return formatState(d.state);
            }}
            ,{field: 'devResult', title: '开发状态', align:'center', templet: function (d) {
                // 调用函数，返回格式化的结果
                return formatDevResult(d.devResult);
            }}
            ,{title:'操作',templet:'#saleChanceListBar', fixed: 'right', align:'center', minWidth:150}
        ]]
    });

    /**
     * 格式化分配状态值
     *  0 = 未分配
     *  1 = 已分配
     *  其他 = 未知
     * @param state
     */
    function formatState(state) {
        if (state == 0) {
            return "<div style='color: yellow'>未分配</div>";
        } else if (state == 1) {
            return "<div style='color: green'>已分配</div>";
        } else {
            return "<div style='color: red'>未知</div>";
        }
    }

    /**
     * 格式化开发状态
     *  0 = 未开发
     *  1 = 开发中
     *  2 = 开发成功
     *  3 = 开发失败
     * @param devResult
     */
    function formatDevResult(devResult) {
        if (devResult == 0) {
            return "<div style='color: yellow'>未开发</div>";
        } else if (devResult == 1) {
            return "<div style='color: orange'>开发中</div>";
        } else if (devResult == 2) {
            return "<div style='color: green'>开发成功</div>";
        } else if (devResult == 3) {
            return "<div style='color: red'>开发失败</div>";
        } else {
            return "<div style='color: blue'>未知</div>";
        }
    }

    $(".search_btn").click(function () {
        /**
         * 表格重载
         *  多条件查询
         */
        tableIns.reload({
            // 设置需要传递给后端的参数
            where: {    // 设定异步数据接口的额外参数，任意设
                // 通过文本框的值，设定传递的参数
                customerName: $("[name='customerName']").val(),    // 客户名称
                createMan: $("[name='createMan']").val(),  // 创建人
                state:  $("#state").val(), //状态
            },
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    });

    /**
     * 监听头部工具栏事件
     *  格式:
     *      table.on('toolbar(数据表格的lay-filter属性值)', function (data) {
     *      });
     */
    table.on('toolbar(saleChances)', function (data) {
        // data.event: 对应的元素上设置的lay-event属性值
        console.log(data)

        // 判断对应的事件类型
        if (data.event == "add") {
            // 添加操作
            openSaleChanceDialog();
        } else if (data.event = "del") {
            // 删除操作
        }
    });

    /**
     * 打开添加/修改营销机会数据的窗口
     *  如果营销机会ID为空，则为添加操作
     *  如果营销机会ID不为空，则为修改操作
     */
    function openSaleChanceDialog(saleChanceId) {
        // 弹出层标题
        var title = "<h3>营销机会管理 - 添加营销机会</h3>";
        var url = ctx + "/sale_chance/toSaleChancePage";

        // 判断营销机会是否为空
        if (saleChanceId != null && saleChanceId != '') {
            // 更新操作
            title = "<h3>营销机会管理 - 修改营销机会</h3>";
            url += '?saleChanceId=' + saleChanceId;
        }

        // iframe层
        layui.layer.open({
            // 类型
            type: 2,
            // 标题
            title: title,
            // 宽高
            area: ['500px', '620px'],
            // url地址
            content: url,
            // 可以最大化与最小化
            maxmin: true
        })
    }

    /**
     * 行工具栏监听事件
     *      table.on('tool(数据表格的lay-filter属性值)', function (data) {
     *      });
     */
    table.on('tool(saleChances)', function (data) {
        console.log(data);
        // 判断类型
        if (data.event == "edit") { // 编辑操作
            // 得到营销机会ID
            var saleChanceId = data.data.id;
            // 打开修改营销机会窗口
            openSaleChanceDialog(saleChanceId);
        } else if (data.event == "del") { // 删除操作

        }
    })
});
