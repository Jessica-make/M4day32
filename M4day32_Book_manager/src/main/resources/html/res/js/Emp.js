// var app=new Vue({
//     el:'.addEmp',
//     data:{
//         username:'',
//         passwd:'',
//         role:'',
//         status:'',
//         date0:''
//     },
//     methods: {
//         add:function () {
//             var username=this.username;
//             var passwd = this.passwd;
//             var role=this.role;
//             var status=this.status;
//             var date0=this.date0;
//             if(username===''){
//                 alert('职位不能为空!');
//                 return;
//             }
//             if(passwd===''){
//                 alert('密码不能为空!');
//                 return;
//             }
//             if(role===''){
//                 alert('职位不能为空!');
//                 return;
//             }
//             if(status===''){
//                 alert('状态不能为空!');
//                 return;
//             }
//             if(date0===''){
//                 alert('状态不能为空!');
//                 return;
//             }
//             $.ajax({
//                 url: '/Save-Emp.ajax',
//                 type:'POST',
//                 data:{
//                     //后端对应前端的数据;
//                     username:username,
//                     passwd:passwd,
//                     role:role,
//                     status:status,
//                     date0:date0
//                 },
//                 dataType:'JSON',
//                 success:function (resp) {
//                     if (resp.type) {
//                         layer.alert('保存成功!');
//                         app.xPage.getList(app.xPage.PageIndex);
//                     } else {
//                         layer.alert('保存失败!');
//                     }
//                 },
//                 error:function () {
//                     alert('系统异常，请与管理员取得联系!');
//                 }
//             });
//         }
//     }
// });
