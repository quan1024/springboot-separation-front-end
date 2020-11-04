//英雄删除
function heroDel(e) {
  // console.log(e.name);
  $.ajax({
    type: "post", //后面用","很容易出错
    url: "http://101.201.102.232:8088/api/deleteHeroByName", //删除的控制器url
    data: { name: e.name },
    success: function () {
      $(this).parent().parent().remove(); //成功后执行的方法
      location.reload(); //刷新
    },
    error: function () {
      alert("传输失败");
      //失败后执行的方法
    },
  });
  // $("button").unbind();
}

function jump(e) {
  // console.log($(this).prev().val());
  location.href = "heroUpdate.html?" + "name=" + encodeURI(e.name);
}


//获取要编辑对象的值
var loc = location.href;
var n1 = loc.length;
var n2 = loc.indexOf("=");
var txt = decodeURI(loc.substr(n2 + 1, n1 - n2));
document.getElementById("ip1").placeholder = txt;

//英雄更新
function heroEdit() {
  $.ajax({
    type: "post",
    url: "http://101.201.102.232:8088/api/updateHeroByName",
    data: {
      name: $("#ip1").attr("placeholder"),
      hp: $("#ip2").val(),
      armor: $("#ip3").val(),
      moveSpeed: $("#ip4").val(),
    },
    dataType: "json", //数据类型为json类型

    success: function (data) {
      //成功时返回的data值，注意这个data是后台返回的值，上面的data是要传给后台的值
      if ((data = 1)) {
        //如果后台返回的data.SuccessCode不等于0执行后面的语句

        alert("编辑成功");
        window.location.href = "heroList.html";
      }
    },

    error: function () {
      //请求失败执行的操作

      alert("操作失败！！");
    },
  });
}

//英雄添加
function heroAdd() {
  $.ajax({
    url: "http://101.201.102.232:8088/api/addHero", //请求后台的地址
    type: "post", //请求方式
    data: {
      //这里是你要传给后台的data值
      name: $("#ip11").val(),
      hp: $("#ip12").val(),
      armor: $("#ip13").val(),
      moveSpeed: $("#ip14").val(),
    },
    dataType: "json", //数据类型为json类型
    success: function (data) {
      //成功时返回的data值，注意这个data是后台返回的值，上面的data是要传给后台的值
      if ((data = 1)) {
        //如果后台返回的data等于1执行后面的语句
        alert("添加成功！");
        window.location.href = "heroList.html";
      }
    },
    error: function () {
      //请求失败执行的操作
      alert("操作失败！！");
    },
  });
}

//用户添加
function userAdd() {
  $.ajax({
    url: "http://101.201.102.232:8088/api/addPlayer", //请求后台的地址
    type: "post", //请求方式
    data: {
      //这里是你要传给后台的data值
      id: $("#ip21").val(),
      name: $("#ip22").val(),
      degree: $("#ip23").val(),
      playhero: $("#mySelect").val(),
    },
    dataType: "json", //数据类型为json类型
    success: function (data) {
      //成功时返回的data值，注意这个data是后台返回的值，上面的data是要传给后台的值
      if ((data = 1)) {
        //如果后台返回的data.SuccessCode不等于0执行后面的语句
        alert("添加成功！");
        window.location.href = "userList.html";
      }
    },
    error: function () {
      //请求失败执行的操作
      alert("操作失败！！");
    },
  });
}


var txt1 = decodeURI(loc.substr(n2+1,n1-n2));
document.getElementById('ip1').placeholder=txt1;
//用户编辑
function userEdit() {
  $.ajax({
    url: "http://101.201.102.232:8088/api/updatePlayerById", //请求后台的地址
    type: "post", //请求方式
    data: 
        {
      //这里是你要传给后台的data值
      id: $("#ip1").attr("placeholder"),
      name: $("#ip2").val(),
      degree: $("#ip3").val(),
      playhero: $("#mySelect").val(),
      },
    dataType: "json", //数据类型为json类型
    success: function (data) {
      //成功时返回的data值，注意这个data是后台返回的值，上面的data是要传给后台的值
      if ((data.SuccessCode = "1")) {
        //如果后台返回的data.SuccessCode不等于0执行后面的语句
        alert("编辑成功！");
        window.location.href="userList.html";
      } 
    },
    error: function () {
      //请求失败执行的操作
        alert("操作失败！！");
    },
  });
} 



//用户删除
function userDel(e) {
  console.log(e.id);
  $.ajax({
    type: "post", //后面用","很容易出错
    url: "http://101.201.102.232:8088/api/deletePlayerById", //删除的控制器url
    data: { id: e.id },
    success: function () {
      $(this).parent().parent().remove(); //成功后执行的方法
      location.reload(); //刷新
    },
    error: function () {
      alert(12);
      //失败后执行的方法
    },
  });
  // $("button").unbind();
}

function jump1(e) {
  // console.log($(this).prev().val());
  location.href = "userUpdate.html?" + "id=" + encodeURI(e.id);
}


//修改密码
function Change() {
        
  $.ajax({  
      type: "POST",   //提交的方法
      url:"http://101.201.102.232:8088/api/modify", //提交的地址  
      data: {
      username: $("#username").val(),
      password: $("#newpassword").val(),
      prepassword: $("#prepassword").val(), 
    },  
      async: false,  
      error: function(request) {  //失败的话
           alert("Connection error");  
      },  
      success: function(data) {  //成功
           if(data=1){
             alert("修改成功")
           }  //就将返回的数据显示出来
           window.location.href="login.html"  
      }  
   });

  
}



//查询功能
$("#search").click(function () {
  if($("[type='text']").val()==''){
    alert("输入值为空");
    return;
  }
  $.ajax({
    type: "POST",
    url: "http://101.201.102.232:8088/api/selectHeroByName", //访问的链接
    data:{name:$("[type='text']").val()},
    dataType: "json", //数据格式设置为jsonp
    json: "callback", //Jquery生成验证参数的名称
    success: function (user_data) {
      //成功的回调函数
      var str = "";
      console.log(user_data);
      str +=
          "<tr>" +
          "<td>" +
            user_data.name +
          "</td>" +
          "<td>" +
            user_data.hp +
          "</td>" +
          "<td>" +
            user_data.armor +
          "</td>" +
          "<td>" +
            user_data.moveSpeed +
          "</td>" +
          "<td>" +
          "<a href='userUpdate.html'>" +
          "<button>编辑</button>" +
          "</a>" +
          "<input type='text' name=" +
          user_data.name +
          " style='display:none'>" +
          "<button onclick='del()' class='deL' " +
          ">删除</button>" +
          "</td>";
      $("#t-body").html(str);
    },
    error: function (e) {
      alert("error");
    },
  });
});