window.onload = function (ev) {
    selectUser();
};

/* 用户搜索 */
selectUser = function () {
    var userSearch = $("#userSearch");
    userSearch.click(function (ev) {
        var value = $("#search").val();
        userSearch.post(
            "adminUser",
            {"userName": value},
            function (reuse) {
                for (var i = 0; i < reuse.length; i++) {
                    var lis = $($(".ul")[i]).find("li");
                    lis[0].innerText = "姓名：" + reuse[i  ].uName;
                    lis[1].innerText = "年龄：" + reuse[i].uAge;
                    lis[2].innerText = "电话号码：" + reuse[i].uSex;
                    lis[3].innerText = "兴趣爱好：" + reuse[i].interest;
                    lis[4].innerText = "用户介绍：" + reuse[i].uIntroduce;
                    lis[5].innerText = "会员：" + reuse[i].isMember;
                    lis[6].innerText = "注册时间：" + reuse[i].uRegistrationTime;
                    lis[7].innerText = "最后登录时间：" + reuse[i].uLoginTime;
                }
                for (var i = $(".ul").length - 1; i >= reuse.length; i--) {
                    console.log(i)
                    var remove = $($("ul")[i]).remove()
                }
            }
        )
    })
};


/* 用户删除 */
deleteUsers = function (e) {
    var value = $($(e).parent().siblings("input")).val();
    $(e).post(
        "deleteUser",
        {"uId": value},
        function (reuse) {
            $(e).remove();
        }
    )
};



