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
      <li><a href="javascript:void (0);">会员详情</a></li>
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
          <span>会员详情</span>
        </div>
      </div>
      <div class="box-content">
        <%--<h4 class="page-header">会员详情</h4>--%>
        <form class="form-horizontal" role="form">
          <input type="hidden" value="${empVO.mm_emp_id}" id="mm_emp_id">
          <input type="hidden" value="${empVO.mm_emp_cover}" id="mm_emp_cover">
          <div class="form-group">
            <label class="col-sm-2 control-label">用户名</label>
              <div class="col-sm-4">
                  <input type="text" id="mm_emp_nickname" class="form-control" value="${empVO.mm_emp_nickname}" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
              </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">用户手机号</label>
            <div class="col-sm-4">
              <input type="text" id="mm_emp_mobile" class="form-control" value="${empVO.mm_emp_mobile}" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" >头像</label>
                <div class="col-sm-10 col-md-2">
                     <img class="img-thumbnail" name="imagePath" id="imageDiv"   style="cursor: pointer"  src="${empVO.mm_emp_cover}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" ></label>
                <div class="col-sm-10">
                    <input type="file" name="file" id="fileUpload" style="float: left;" />
                    <input type="button" value="上传" onclick="uploadImage()" style="float: left;"/><br/><br/>
                </div>
            </div>
          <%--<div class="form-group">--%>
            <%--<label class="col-sm-2 control-label">用户密码</label>--%>
            <%--<div class="col-sm-4">--%>
              <%--<input type="text" id="mm_emp_password" class="form-control" value="${empVO.mm_emp_password}" data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">--%>
            <%--</div>--%>
          <%--</div>--%>

          <div class="form-group">
            <label class="col-sm-2 control-label">用户类型</label>
            <div class="col-sm-4">
              <select class="form-control" id="mm_emp_type">
                <option value="">--选择用户类型--</option>
                <option value="0" ${empVO.mm_emp_type=='0'?'selected':''}>普通用户</option>
                <option value="1" ${empVO.mm_emp_type=='1'?'selected':''}>会员</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">注册日期</label>
            <div class="col-sm-4">
              <input type="text" id="mm_emp_regtime" readonly="true" class="form-control" value="${empVO.mm_emp_regtime}" >
            </div>
          </div>


          <div class="form-group">
            <label class="col-sm-2 control-label">允许登陆</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_login">
                <option value="">--请选择--</option>
                <option value="0" ${empVO.is_login=='0'?'selected':''}>允许</option>
                <option value="1" ${empVO.is_login=='1'?'selected':''}>不允许</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">发布信息权限</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_fabu">
                <option value="">--请选择--</option>
                <option value="0" ${empVO.is_fabu=='0'?'selected':''}>不允许</option>
                <option value="1" ${empVO.is_fabu=='1'?'selected':''}>允许</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">是否禁用</label>
            <div class="col-sm-4">
              <select class="form-control" id="is_use">
                <option value="">--请选择--</option>
                <option value="0" ${empVO.is_use=='0'?'selected':''}>否</option>
                <option value="1" ${empVO.is_use=='1'?'selected':''}>是</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">是否审核</label>
            <div class="col-sm-4">
              <select class="form-control" id="ischeck">
                <option value="">--请选择--</option>
                <option value="0" ${empVO.ischeck=='0'?'selected':''}>未审核</option>
                <option value="1" ${empVO.ischeck=='1'?'selected':''}>已审核</option>
                <option value="2" ${empVO.ischeck=='2'?'selected':''}>未通过</option>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
              <button type="button" class="btn btn-primary" onclick="saveRole('${empVO.mm_emp_id}')">确定修改</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

  function saveRole(mm_emp_id){
    var mm_emp_id = $("#mm_emp_id").val();
    var mm_emp_mobile = $("#mm_emp_mobile").val();
    var mm_emp_nickname = $("#mm_emp_nickname").val();
    var mm_emp_type = $("#mm_emp_type").val();
    var mm_emp_regtime = $("#mm_emp_regtime").val();
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

    if(is_use.replace(/\s/g, '') == ''){
      alert("请选择是否禁用");
      return;
    }
    if(ischeck.replace(/\s/g, '') == ''){
      alert("请选择是否审核");
      return;
    }

      var imagePath = $("img[name='imagePath']").attr("src");

      if(imagePath== "" || imagePath==null){
          imagePath = $("#mm_emp_cover").val();
          return;
      }

    $.ajax({
      cache: true,
      type: "POST",
      url:"/emp/updateEmp.do",
      data:{
        "mm_emp_id":mm_emp_id,
        "mm_emp_cover":imagePath,
        "mm_emp_mobile":mm_emp_mobile,
        "mm_emp_nickname":mm_emp_nickname,
        "mm_emp_type":mm_emp_type,
        "mm_emp_regtime":mm_emp_regtime,
        "is_login":is_login,
        "is_use":is_use,
        "ischeck":ischeck
      },
      async: false,
      success: function(_data) {
        var data = $.parseJSON(_data);
        if(data.success){
          alert("修改成功");
          window.location.href = "#module=emp/detail&mm_emp_id=" + mm_emp_id;
        }else{
          var _case = {1:"修改失败"};
          alert(_case[data.code])
        }
      }
    });
  };


</script>

<script type="text/javascript">
    function uploadImage() {
        $.ajaxFileUpload(
                {
                    url:"/uploadUnCompressImage.do?_t=" + new Date().getTime(),            //需要链接到服务器地址
                    secureuri:false,//是否启用安全提交，默认为false
                    fileElementId:'fileUpload',                        //文件选择框的id属性
                    dataType: 'json',                                     //服务器返回的格式，可以是json, xml
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                        if(data.success) {
                            document.getElementById('imageDiv').src= data.data;
                        } else {
                            if(data.code == 1) {
                                alert("上传图片失败");
                            } else if(data.code == 2) {
                                alert("上传图片格式只能为：jpg、png、gif、bmp、jpeg");
                            } else if(data.code == 3) {
                                alert("请选择上传图片");
                            }else {
                                alert("上传失败");
                            }
                        }
                    }
                }
        );
    }

    function deleteImage(e, node) {
        if(e.button == 2) {
            if(confirm("确定移除该图片吗？")) {
                $(node).remove();
            }
        }
    };

</script>
