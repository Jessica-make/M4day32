// 定义过滤器 ，如果有传值，用format，如果没传值默认用'YYYY-MM-DD HH:mm:ss'

// Vue.filter('dateString', function (value, format='YYYY-MM-DD HH:mm:ss') {
//     // 格式化一下，在返回回去;
//     return moment(value).format(format);
// })




var app=new Vue({
    el:".login",
    data :{
        username:'',
        passwd :'',
        time:new Date()
    },
    methods :{
        doLogin :function () {
          var username=this.username;
          var passwd  =this.passwd;
            if (username===''){
                alert("用户名不能为空!");
                return;
            }
            if (passwd===''){
                alert("密码不能为空");
                return;
            }

            $.ajax({
                url:"/login.ajax",
                type :"POST",
                data:{
                    username :username,
                    passwd: passwd
                },
                dataType :"JSON",
                success :function (resp,data) {
                     if (resp.code===0){
                         alert("登录成功!");
                         window.location.href="main.html";
                     }else {
                         alert("用户名或密码错误，请重新输入!");
                     }
                },
                error :function () {
                     alert("程序错误，请与管理员取得联系!");
                }
            })
        },
        keyDown(e){
            //如果是回车则执行登录方法
            if(e.keyCode === 13){
                this.doLogin();
            }
        },
        destroyed(){
            window.removeEventListener('keydown',this.keyDown,false);
        }
    },

    mounted(){
            //绑定监听事件
            window.addEventListener('keydown',this.keyDown);
        // add2(){
        //     setInterval(() => {
        //         this.time = new Date()
        //     }, 1000)
        // }
    },

})










