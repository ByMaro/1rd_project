<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Fitness &amp;amp; Yoga, ​Yoga for Relaxation, ​Gain balance, strength, and flexibility for your body and mind, Our training plan for complete beginners, ​Join Our Newsletter">
    <meta name="description" content="">
    <title>new_user_survey</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="new_user_survey.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <!-- <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script> -->
    <meta name="generator" content="Nicepage 4.12.14, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/male-silhouette-variant-showing-muscles.png"
}</script>
    <meta name="theme-color" content="#f67460">
    <meta property="og:title" content="new_user_survey">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode"><header class="u-clearfix u-header u-header" id="sec-fdc6"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
          <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
        </a>
        <h3 class="u-text u-text-default u-text-1">운동 헬스업<br>
        </h3>
      </div></header>
    <section class="u-clearfix u-section-1" id="sec-fa9b">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-expanded-width-xs u-form u-form-1">
        
        <!-- 
        	사용자에게 선호 운동부위(1,2순위)
        	선호 운동기구(1,2순위)
        	비선호 운동 부위
        	운동 난이도(1,2순위) 를 입력 받음
        	->어제자 운동은 자동 조회
         -->
        
          <form action="reco_algo" method="POST" class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 10px;">
            <div class="u-form-group u-form-select u-label-top u-form-group-1">
              <label for="select-37b4" class="u-label">운동 부위 선택</label>
              <div class="u-form-select-wrapper">
                <select id="select-37b4" name="parts1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Arms">팔</option>
                  <option value="Back">등</option>
                  <option value="Hips">엉덩이</option>
                  <option value="Legs">하체</option>
                  <option value="Chest">가슴</option>
                  <option value="Shoulders">어깨</option>
                  <option value="Full Body">전신</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-form-select u-label-top u-form-group-1">
            <label for="select-37b4" class="u-label">운동 부위 선택2</label>
              <div class="u-form-select-wrapper">
                <select id="select-37b4" name="parts2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Arms">팔</option>
                  <option value="Back">등</option>
                  <option value="Hips">엉덩이</option>
                  <option value="Legs">하체</option>
                  <option value="Chest">가슴</option>
                  <option value="Shoulders">어깨</option>
                  <option value="Full Body">전신</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-form-select u-label-top u-form-group-2">
              <label for="select-0e21" class="u-label">운동 기구 선택</label>
              <div class="u-form-select-wrapper">
                <select id="select-0e21" name="equip1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Barbell">바벨</option>
                  <option value="Dumbells">덤벨</option>
                  <option value="Weight Machines / Selectorized">머신</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
             <div class="u-form-group u-form-select u-label-top u-form-group-2">
              <label for="select-0e21" class="u-label">운동 기구 선택2</label>
              <div class="u-form-select-wrapper">
                <select id="select-0e21" name="equip2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Barbell">바벨</option>
                  <option value="Dumbells">덤벨</option>
                  <option value="Weight Machines / Selectorized">머신</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            
            <div class="u-form-group u-form-select u-label-top u-form-group-3">
              <label for="select-3739" class="u-label">운동 난이도 선택</label>
              <div class="u-form-select-wrapper">
                <select id="select-3739" name="dif1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Beginner">Beginner</option>
                  <option value="Intermediate">Intermediate</option>
                  <option value="Advanced">Advanced</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            <div class="u-form-group u-form-select u-label-top u-form-group-3">
              <label for="select-3739" class="u-label">운동 난이도 선택2</label>
              <div class="u-form-select-wrapper">
                <select id="select-3739" name="dif2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Beginner">Beginner</option>
                  <option value="Intermediate">Intermediate</option>
                  <option value="Advanced">Advanced</option>
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
            
            <div class="u-form-group u-form-select u-label-top u-form-group-4">
              <label for="select-4771" class="u-label">비선호 부위 선택</label>
              <div class="u-form-select-wrapper">
                <select id="select-4771" name="hateparts" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                  <option value="Arms">팔</option>
                  <option value="Back">등</option>
                  <option value="Hips">엉덩이</option>
                  <option value="Legs">하체</option>
                  <option value="Chest">가슴</option>
                  <option value="Shoulders">어깨</option>
                  <option value="Full Body">전신</option>
                  <option value="None">없음</option>
                  
                </select>
                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
              </div>
            </div>
          

           
            <div class="u-align-left u-form-group u-form-submit u-label-top">
              <input type="submit" value="보내기"  class="u-btn u-btn-submit u-button-style">
            </div>
            <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
            <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
            <input type="hidden" value="" name="recaptchaResponse">
          </form>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-80dc"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">created with 진석, 지민, 민호, 규창, 감중</p>
      </div></footer>
   
  </body>
</html>