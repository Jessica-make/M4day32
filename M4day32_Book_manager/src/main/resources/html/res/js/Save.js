//
// var app=
//
//
// //保存
// save: function () {
//     $.ajax({
//         url: '/Save-Emp.ajax',
//         type: 'POST',
//         data: {
//             //修改需要id;
//             id: app.ed.id,
//             username: app.ed.username,
//             passwd: app.ed.passwd,
//             role: app.ed.role,
//             status: app.ed.status,
//             date0: app.ed.date0
//         },
//         dataType: 'JSON',
//         success: function (resp) {
//             if (resp.type) {
//                 layer.alert('保存成功!');
//                 app.closeMo();
//                 app.xPage.getList(app.xPage.PageIndex);
//             } else {
//                 layer.alert('保存失败!');
//             }
//         },
//         error: function () {
//             layer.alert('err');
//         }
//     })
// }