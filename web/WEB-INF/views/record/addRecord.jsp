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
      <li><a href="javascript:void (0);">信息管理</a></li>
      <li><a href="javascript:void (0);">添加信息</a></li>
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
          <span>添加信息</span>
        </div>
      </div>
      <div class="box-content">
        <%--<h4 class="page-header">会员详情</h4>--%>
        <form class="form-horizontal" role="form">

          <div class="form-group">
            <label class="col-sm-2 control-label">信息标题</label>
              <div class="col-sm-4">
                  <input type="text" id="mm_msg_title" placeholder="信息标题" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
              </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">信息内容</label>
            <div class="col-sm-4">
              <input type="text" id="mm_msg_content" placeholder="信息内容" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">图片地址</label>
            <div class="col-sm-4">
              <input type="text" id="mm_msg_picurl" placeholder="图片地址" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-2 control-label">视频地址</label>
            <div class="col-sm-4">
              <input type="text" id="mm_msg_videourl" placeholder="视频地址" class="form-control"  data-toggle="tooltip" data-placement="bottom" title="Tooltip for name">
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
    var mm_msg_title = $("#mm_msg_title").val();
    var mm_msg_content = $("#mm_msg_content").val();
    var mm_msg_picurl = $("#mm_msg_picurl").val();
    var mm_msg_videourl = $("#mm_msg_videourl").val();

    if(mm_msg_title.replace(/\s/g, '') == ''){
        alert("标题不能为空");
        return;
    }
    if(mm_msg_picurl.replace(/\s/g, '') == ''){
      alert("图片不能为空");
      return;
    }
    if(mm_msg_videourl.replace(/\s/g, '') == ''){
        alert("视频不能为空");
        return;
    }

    $.ajax({
      cache: true,
      type: "POST",
      url:"/sendRecord.do",
      data:{
        "mm_msg_title":mm_msg_title,
        "mm_msg_content":mm_msg_content,
        "mm_msg_picurl":mm_msg_picurl,
        "mm_msg_videourl":mm_msg_videourl
      },
      async: false,
      success: function(_data) {
        var data = $.parseJSON(_data);
        if(data.success){
          alert("保存成功");
          window.location.href = "#module=record/toAdd" ;
        }else{
          var _case = {1:"保存失败"};
          alert(_case[data.code])
        }
      }
    });
  };


</script>


