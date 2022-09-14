<%@page import="com.model.training_infoDAO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.util.List"%>
<%@page import="com.model.training_infoVO"%>
<%@page import="com.model.userid_training_listVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Fitness &amp;amp; Yoga, ​Yoga for Relaxation, ​Gain balance, strength, and flexibility for your body and mind, Our training plan for complete beginners, ​Join Our Newsletter">
    <meta name="description" content="">
    <title>view_recom</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
    <link rel="stylesheet" href="exercise.css" media="screen">
    <link rel="stylesheet" href="view_recom.css" media="screen">
    <link rel="stylesheet" href="new_user.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <!-- <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script> -->
    <meta name="generator" content="Nicepage 4.12.14, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">

<!-- 
	운동 추천후 사용자가 원하는 세트,회수/초(시간)을 입력받는 페이지
 -->
<%
 List<Integer> q = (List<Integer>)request.getAttribute("q");
 session.setAttribute("q", q);
 training_infoDAO dao = new training_infoDAO();
%>

    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/male-silhouette-variant-showing-muscles.png"
}</script>
    <meta name="theme-color" content="#f67460">
    <meta property="og:title" content="view_recom">
    <meta property="og:type" content="website">
  </head>
  <body data-home-page="view_recom.html" data-home-page-title="view_recom" class="u-body u-xl-mode"><header class="u-clearfix u-header" id="sec-fdc6"><div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xl u-sheet-1">
        <%
        List<userid_training_listVO> vo = null;
        %>
        
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
          <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
        </a>
        <h2 class="u-text u-text-default-xs u-tu-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-2ext-1">오늘의 운동 추천</h2>
      </div></header>
    <section class="u-clearfix u-grey-10 u-section-1" id="sec-f395">
      <div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xl u-sheet-1">
        <div class="u-expanded-width u-layout-horizontal u-list u-list-1">
          
          
          <form action="surveyinsert">
          
            
          <div class="u-repeater u-repeater-1">
            
            <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                <img alt="" class="u-image u-image-circle u-image-1" src="<%="./copy_img/"+dao.select_training_name(q.get(0))+".gif" %>" data-image-width="512" data-image-height="512">
               
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-1">
                </h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-2">
                <h1><%=dao.select_training_name(q.get(0)) %> </h1>
                <input type="text" placeholder="세트수" id="text-4500" name="set_val1" class="u-border-1 u-border-grey-30 u-input u-input-dngle u-white"><br>
                </p>
               <p class="u-align-center-xs u-text u-text-3"><input type="text" placeholder="개수" id="text-4500" name="secncnt_val1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p>
               <br>
               </div>
           
          
            </div>
           <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
              
                <img alt="" class="u-image u-image-circle u-image-1" src="<%="./copy_img/"+dao.select_training_name(q.get(1))+".gif" %>" data-image-width="512" data-image-height="512">
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-1">
                </h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-2">
                <h1><%=dao.select_training_name(q.get(1)) %> </h1>
                <input type="text" placeholder="세트수" id="text-4500" name="set_val2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"><br>
                </p>
               <p class="u-align-center-xs u-text u-text-3"><input type="text" placeholder="개수" id="text-4500" name="secncnt_val2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p> 
              </div>
            </div>
            
            
            <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                <img alt="" class="u-image u-image-circle u-image-1" src="<%="./copy_img/"+dao.select_training_name(q.get(2))+".gif" %>" data-image-width="512" data-image-height="512">
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-1">
                </h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-2">
                <h1><%=dao.select_training_name(q.get(2)) %> </h1>
                <input type="text" placeholder="세트수" id="text-4500" name="set_val3" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"><br>
                </p>
               <p class="u-align-center-xs u-text u-text-3"><input type="text" placeholder="개수" id="text-4500" name="secncnt_val3" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p> 
              </div>
            </div>
           
          </div>
          
          <input type="submit" value="저장" class="u-btn u-btn-submit u-button-style" style="position:fixed; left:210px; bottom:110px; transform : translate(-50%, -50%) ">
        
          </form>
          
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-80dc"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">created with 진석, 지민, 민호, 규창, 감중</p>
      </div></footer>
   
  </body>
</html>