<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="um" uri="/unimanager-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<div class="row">
  <div id="breadcrumb" class="col-xs-12">
    <a href="#" class="show-sidebar">
      <i class="fa fa-bars"></i>
    </a>
    <ol class="breadcrumb pull-left">
      <li><a href="javascript:void(0)"  onclick="toPage('mainPage','')">主页</a></li>
      <li><a href="javascript:void (0);">会员管理</a></li>
      <li><a href="javascript:void (0);">人工注册</a></li>
    </ol>
    <div id="social" class="pull-right">
      <a href="javascript:void(0)"><i class="fa fa-google-plus"></i></a>
      <a href="javascript:void(0)"><i class="fa fa-facebook"></i></a>
      <a href="javascript:void(0)"><i class="fa fa-twitter"></i></a>
      <a href="javascript:void(0)"><i class="fa fa-linkedin"></i></a>
      <a href="javascript:void(0)"><i class="fa fa-youtube"></i></a>
    </div>
  </div>
</div>

<div class="row">
  <div class="col-xs-12 col-sm-12">
    <div class="box">
      <div class="box-header">
        <div class="box-name">
          <i class="fa fa-search"></i>
          <span>人工注册</span>
        </div>
      </div>
      <div class="box-content">
        <%--<h4 class="page-header">会员详情</h4>--%>
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <label class="col-sm-2 control-label">用户名</label>
              <div class="col-sm-4">
                  <input type="text" id="mm_emp_nickname" placeholder="真实姓名" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
              </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">用户手机号</label>
            <div class="col-sm-4">
              <input type="text" id="mm_emp_mobile" placeholder="手机号" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">用户密码</label>
            <div class="col-sm-4">
              <input type="text" id="mm_emp_password" placeholder="6到18位密码" class="form-control" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>


          <div class="form-group">
            <label class="col-sm-2 control-label">用户类型</label>
            <div class="col-sm-4">
              <select class="form-control" id="mm_emp_type">
                <option value="">--选择用户类型--</option>
                <option value="0" selected="selected">普通用户</option>
                <option value="1" >会员</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">允许登陆</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_login">
                <option value="">--请选择--</option>
                <option value="0" selected="selected">允许</option>
                <option value="1" >不允许</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">发布信息权限</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_fabu">
                <option value="">--请选择--</option>
                <option value="0"  selected="selected">不允许</option>
                <option value="1" >允许</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">是否禁用</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_use">
                <option value="">--请选择--</option>
                <option value="0" selected="selected" >否</option>
                <option value="1" >是</option>
              </select>
            </div>
          </div>


          <div class="form-group">
            <label class="col-sm-2 control-label">是否审核</label>
            <div class="col-sm-4">
              <select class="form-control" id="ischeck">
                <option value="">--请选择--</option>
                <option value="0" >未审核</option>
                <option value="1" selected="selected" >已审核</option>
                <option value="2" >未通过</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
              <button type="button" class="btn btn-primary" onclick="saveRole()">确定</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

  function saveRole(mm_emp_id){
    var mm_emp_mobile = $("#mm_emp_mobile").val();
    var mm_emp_nickname = $("#mm_emp_nickname").val();
    var mm_emp_password = $("#mm_emp_password").val();
    var mm_emp_type = $("#mm_emp_type").val();
    var is_login = $("#is_login").val();
    var is_fabu = $("#is_fabu").val();
    var is_use = $("#is_use").val();
    var ischeck = $("#ischeck").val();

    if(mm_emp_nickname.replace(/\s/g, '') == ''){
        alert("名称不能为空");
        return;
    }
    if(mm_emp_mobile.replace(/\s/g, '') == ''){
      alert("手机号不能为空");
      return;
    }
    if(mm_emp_password.replace(/\s/g, '') == ''){
        alert("密码不能为空");
        return;
    }
    if(mm_emp_password.length<6 || mm_emp_password.length>18){
      alert("密码长度至少6位,最多18位");
      return;
    }
    if(mm_emp_type.replace(/\s/g, '') == ''){
      alert("请选择用户类型");
      return;
    }

    if(is_login.replace(/\s/g, '') == ''){
      alert("请选择是否允许登陆");
      return;
    }
    if(is_fabu.replace(/\s/g, '') == ''){
      alert("请选择发布信息权限");
      return;
    }
    if(ischeck.replace(/\s/g, '') == ''){
      alert("请选择是否审核");
      return;
    }
    $.ajax({
      cache: true,
      type: "POST",
      url:"/emp/empReg.do",
      data:{
        "mm_emp_mobile":mm_emp_mobile,
        "mm_emp_nickname":mm_emp_nickname,
        "mm_emp_type":mm_emp_type,
        "mm_emp_password":mm_emp_password,
        "is_login":is_login,
        "is_fabu":is_fabu,
        "is_use":is_use,
        "ischeck":ischeck
      },
      async: false,
      success: function(_data) {
        var data = $.parseJSON(_data);
        if(data.success){
          alert("注册成功");
          window.location.href = "#module=emp/toReg" ;
        }else{
          var _case = {1:"注册失败",2:"该手机号已经注册，请换个手机号试试"};
          alert(_case[data.code])
        }
      }
    });
  };


</script>


