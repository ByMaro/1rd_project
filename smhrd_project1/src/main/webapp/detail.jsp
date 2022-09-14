<%@page import="com.model.userid_training_listVO"%>
<%@page import="com.model.user_infoVO"%>
<%@page import="com.model.userid_training_listDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Fitness &amp;amp; Yoga, ​Yoga for Relaxation, ​Gain balance, strength, and flexibility for your body and mind, Our training plan for complete beginners, ​Join Our Newsletter">
    <meta name="description" content="">
    <title>main_page</title>
    <link rel="stylesheet" href="detail1.css" media="screen">
<link rel="stylesheet" href="detail.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.12.17, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <
   
   <% 
   //추천을 이미 받았다면 추천 받은 운동, 세트, 회수를 나타냄
   //캘린더 조회 페이지에서 해당 날짜의 운동의 조회
   
   userid_training_listDAO dao = new userid_training_listDAO();
   userid_training_listVO usertvo = new userid_training_listVO();
   
   String user_id =((user_infoVO)session.getAttribute("uvo")).getUser_id();
   String date = (String)session.getAttribute("data");
   usertvo.setUser_id(user_id);
   usertvo.setTraining_date(date);
   List<userid_training_listVO> vo = dao.select_training_byId(usertvo); 
   request.setAttribute("vo", vo);
   %>
  
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/male-silhouette-variant-showing-muscles.png"
}</script>
    <meta name="theme-color" content="#f67460">
    <meta property="og:title" content="main_page">
    <meta property="og:type" content="website">
  </head>
  <body data-home-page="main_page.html" data-home-page-title="main_page" class="u-body u-xl-mode"><header class="u-clearfix u-header u-header" id="sec-fdc6"><a href="main_login_success.jsp" class="go_main u-btn u-btn-round u-button-style u-hover-palette-1-light-1 u-palette-1-base u-radius-50 u-btn-1">메인페이지</a><a href="https://nicepage.com/k/ticket-html-templates" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
        <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
      </a><h3 class="u-text u-text-default-xs u-text-1">상세 설명</h3></header>
    <section class="u-clearfix u-section-1" id="sec-b47c">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-expanded-width u-list u-list-1">
          <div class="u-repeater u-repeater-1">
            <div class="u-border-2 u-border-grey-75 u-container-style u-list-item u-repeater-item u-list-item-1">
              <div class="u-container-layout u-similar-container u-container-layout-1">
               
                <div class="iframe_area">
                        <img style="margin-left:13px" class="iframe_img" src="./copy_img/<%=vo.get(0).getTraining_name() %>.gif"
                           name="test1" width=310 height=400
                           sandbox="allow-scripts allow-popups" marginWidth=0
                           marginHeight=0 frameBorder=no scrolling=no allowfullscreen>
                     </div>
                
                <p class="u-align-center-xs u-text u-text-default-xs u-text-1">운동명 :  <%=vo.get(0).getTraining_name() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-1">세트수   :    <%=vo.get(0).getSet_val() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-1">횟수   :   <%=vo.get(0).getSecncnt_val() %></p>
              </div>
            </div>
            <div class="u-border-2 u-border-grey-75 u-container-style u-list-item u-repeater-item u-list-item-2">
              <div class="u-container-layout u-similar-container u-container-layout-2">
              
               <div class="iframe_area">
                        <img style="margin-left:13px" class="iframe_img" src="./copy_img/<%=vo.get(1).getTraining_name() %>.gif"
                           name="test1" width=310 height=400
                           sandbox="allow-scripts allow-popups" marginWidth=0 
                           marginHeight=0 frameBorder=no scrolling=no allowfullscreen>
                     </div>
                     
                <p class="u-align-center-xs u-text u-text-default-xs u-text-4">운동명 :  <%=vo.get(1).getTraining_name() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-4">세트수   :   <%=vo.get(1).getSet_val() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-4">횟수   :   <%=vo.get(1).getSecncnt_val() %></p>
              </div>
            </div>
            <div class="u-border-2 u-border-grey-75 u-container-style u-list-item u-repeater-item u-list-item-3">
              <div class="u-container-layout u-similar-container u-container-layout-3">
              
               <div class="iframe_area">
                        <img style="margin-left:13px" class="iframe_img" src="./copy_img/<%=vo.get(2).getTraining_name() %>.gif"
                           name="test1" width=310 height=400
                           sandbox="allow-scripts allow-popups" marginWidth=0
                           marginHeight=0 frameBorder=no scrolling=no allowfullscreen>
                     </div>
                <p class="u-align-center-xs u-text u-text-default-xs u-text-7">운동명 :  <%=vo.get(2).getTraining_name() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-7">세트수   :   <%=vo.get(2).getSet_val() %></p>
                <p class="u-align-left-xs u-text u-text-default-xs u-text-7">횟수   :   <%=vo.get(2).getSecncnt_val() %></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-80dc"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">created with 진석, 지민, 민호, 규창, 감중</p>
      </div></footer>
  </body>
</html>