
var xPage={
    //地址;
    url:'',
    //列表数据;
    dataList:[],
    bookimage:'',
    //搜索数据;
    sds:{},
    //分页数据;
    PageIndex:1,
    //最大页;
    PageMax:1,
    //分页数
    PageSize:5,
    //分页序号;
    PageList:[],
    //上一页;
    upPage:function(){
        //只有大于1的时候才有上一页;
        if (xPage.PageIndex > 1){
            xPage.PageIndex=xPage.PageIndex-1;
            //调用列表数据，展示当前页;
            xPage.getdataList(xPage.PageIndex);
        }
    },
    //下一页;
    downPage:function(){
        //只有小于max页，才有下一页的说法;
        if (xPage.PageIndex< xPage.PageMax){
            xPage.PageIndex=xPage.PageIndex+1;
            //调用列表数据，展示当前页;
            xPage.getdataList(xPage.PageIndex);
        }
    },

    //计算分页;
    runPage:function(max){
        xPage.PageMax=max;
        xPage.PageList=[];
        for (var i=1;i<=max;i++){
            xPage.PageList.push(i);
        }
    },
    //获取列表数据;
    getdataList:function (PageIndex) {
        xPage.PageIndex=PageIndex;
        $.ajax({
            url:xPage.url,
            type:'POST',
            data:{
                //后端对应前端;
                PageIndex :PageIndex,
                PageSize: xPage.PageSize,
                sd:JSON.stringify(xPage.sds),
            },
            dataType:'JSON',
            success:function (resp) {
                // console.log(resp)
                xPage.dataList=resp.booknamebok.dataList;
                console.log(xPage.dataList);
                //调用计算分页方法;
                xPage.runPage(resp.booknamebok.pageCount);
            },
            error:function () {
                layer.alert('系统错误!');
            }
        });
    },
    //初始化方法;
    init:function (url) {
        xPage.url=url;
        //直接拿当前页;
        xPage.getdataList(xPage.PageIndex);
    }

};