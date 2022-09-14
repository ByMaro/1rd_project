<%@page import="com.model.user_infoVO"%>
<%@page import="com.model.usertlVO"%>
<%@page import="com.model.memberTDAO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.model.userid_training_listVO"%>
<%@page import="java.util.List"%>
<%@page import="com.model.userid_training_listDAO"%>
<%@page import="com.model.training_infoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="font-size: 16px;">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>Contact</title>
    <link rel="stylesheet" href="Record.css" media="screen">
    
    <link rel="stylesheet" href="nicepage.css">
    <link rel="stylesheet" href="Page-1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta name="generator" content="Nicepage 4.12.14, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">



    <script type="application/ld+json">
    {
      "@context": "http://schema.org",
      "@type": "Organization",
      "name": "",
      "logo": "images/default-logo.png"
    }
    </script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Contact">
    <meta property="og:type" content="website">
</head>

<body class="u-body u-xl-mode">


    <header class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-clearfix u-header u-header" id="sec-fdc6">
        
        <div class="u-clearfix u-sheet u-valign-middle-xs u-sheet-1">
            <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
              <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
            </a>
            <h2 class="u-text u-text-default-xs u-text-1">운동 기록</h2>
          </div>
    </header>
   
        <div class="u-clearfix u-sheet u-sheet-1">

            <div class="sec_cal" style="border-bottom: 1px solid black;">
                <div class="cal_nav">
                    <a href="javascript:;" class="nav-btn go-prev">prev</a>
                    <div class="year-month"></div>
                    <a href="javascript:;" class="nav-btn go-next">next</a>
                </div>
                <div class="cal_wrap">
                    <div class="days">
                        <div class="day">MON</div>
                        <div class="day">TUE</div>
                        <div class="day">WED</div>
                        <div class="day">THU</div>
                        <div class="day">FRI</div>
                        <div class="day">SAT</div>
                        <div class="day">SUN</div>
                    </div>
                    <div class="dates">
                        <img src="" alt="">
                    </div>

                </div>

            </div>

            <section style="border-bottom: 1px solid black">
              <div>
                <div>
                  <a href="detail.jsp">
                    <div>
                      <div>
                        <div> 
                          <p>
                            1.
                          </p>
                        </div>
                      </div>
                      <div>
                        <div>
                          <p>
                            2.
                          </p>
                        </div>
                      </div>
                      <div>
                        <div> 
                          <p>
                            3.
                          </p>
                        </div>
                      </div>
                    </div>
                  </a>
                </div>
              </div>
            </section>
                 
            <script 
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
            crossorigin="anonymous">
            </script>
            
            
            <script>
                $(document).ready(function () {
                    calendarInit();
                });
                
                /*
                    달력 렌더링 할 때 필요한 정보 목록 
                
                    현재 월(초기값 : 현재 시간)
                    금월 마지막일 날짜와 요일
                    전월 마지막일 날짜와 요일
                */

                function calendarInit() {

                    // 날짜 정보 가져오기
                    var date = new Date(); // 현재 날짜(로컬 기준) 가져오기
                    var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
                    var kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
                    var today = new Date(utc + kstGap); // 한국 시간으로 date 객체 만들기(오늘)

                    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
                    // 달력에서 표기하는 날짜 객체


                    var currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
                    var currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
                    var currentDate = thisMonth.getDate(); // 달력에서 표기하는 일

                    // kst 기준 현재시간
                    // console.log(thisMonth);

                    // 캘린더 렌더링
                    renderCalender(thisMonth);

                    function renderCalender(thisMonth) {

                        // 렌더링을 위한 데이터 정리
                        currentYear = thisMonth.getFullYear();
                        currentMonth = thisMonth.getMonth();
                        currentDate = thisMonth.getDate();

                        // 이전 달의 마지막 날 날짜와 요일 구하기
                        var startDay = new Date(currentYear, currentMonth, 0);
                        var prevDate = startDay.getDate();
                        var prevDay = startDay.getDay();

                        // 이번 달의 마지막날 날짜와 요일 구하기
                        var endDay = new Date(currentYear, currentMonth + 1, 0);
                        var nextDate = endDay.getDate();
                        var nextDay = endDay.getDay();

                        // console.log(prevDate, prevDay, nextDate, nextDay);

                        // 현재 월 표기
                        $('.year-month').text(currentYear + '.' + (currentMonth + 1));

                        // 렌더링 html 요소 생성
                        calendar = document.querySelector('.dates')
                        calendar.innerHTML = '';


                      
                        // 지난달
                        for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
                        }
                        
                        
                        // 이번달
                        for (var i = 1; i <= nextDate; i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div id="this_month_day" class="day current">' + i + '</div>'

                        }
                       

                        // 다음달
                        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
                        }


                        // 오늘 날짜 표기
                        if (today.getMonth() == currentMonth) {
                            todayDate = today.getDate();
                            var currentMonthDate = document.querySelectorAll('.dates .current');
                            currentMonthDate[todayDate - 1].classList.add('today');
                        }
                        
                     // 날짜 클릭했을 때
                        $('.day').click(function () {
                        // function
     
                        $(".day").removeClass("today");
                        $(this).removeClass("today").addClass("today");
                        $("u-repeater u-repeater-1").removeClass("u-repeater u-repeater-1");
                        
                       
                        let data2 = $("div.year-month").text();
                        data2 = data2.split('.');
                        let data = $(this).text();
                     let result = data2[0]+'/'+data2[1]+'/'+data;
                     
                     console.log(result)
                     
                        
                        //console.log(day_current_today[]);
                        // 클릭하면 src 이미지 경로를 그날 했던 운동 정보이름이랑 같은걸 다 가져와서 보여주기
                        // src="./images/bar/Deadlift-2.jpg"
                        
                        //클릭할 때 마다 비동기식 통신방식(ajax)을 사용해서 cal.java파일로 데이터 요청
                        // cal.java로 보내줘야하는 데이터 : result(날짜)
                        // list --> json구조로 받아오는게 가장 사용하기 편해요.
                        $.ajax({
                   // 요청할 서버의 url
                      url : "cal",
                      type : "GET",
                      // 반드시 키값을 달아서 데이터를 전송해줄것
                      //"data =" 띄어쓰기 ㄴㄴ
                      //data : "data="+data,
                      data : "data="+result,
                      // 받아올 결과값의 자료형을 지정하기
                      dataType : 'json',
                      success : function(res) {
                         console.log(res);
                         
                         
                         //console.log('성공!');
                         // 하단에 res안에 들어있는 데이터가 출력될 수 있게끔 
                      
                      
                         if(res.length==0){
                            $('div:nth-child(1) > div > p').html('<span>'+"운동기록이없습니다."+'</span>')
                            $('div:nth-child(2) > div > p').html('<span>'+"운동기록이없습니다."+'</span>')
                            $('div:nth-child(3) > div > p').html('<span>'+"운동기록이없습니다."+'</span>')
                         }else{
                            $('div:nth-child(1) > div > p').html('<span>'+"운동이름 : "+res[0].training_name+'<br>'+"세트 : "+ res[0].set_val+'<br>'+"횟수 :"+res[0].secncnt_val+'</span>')        
                            $('div:nth-child(2) > div > p').html('<span>'+"운동이름 : "+res[1].training_name+'<br>'+"세트 : "+ res[1].set_val+'<br>'+"횟수 :"+res[1].secncnt_val+'</span>')        
                            $('div:nth-child(3) > div > p').html('<span>'+"운동이름 : "+res[2].training_name+'<br>'+"세트 : "+ res[2].set_val+'<br>'+"횟수 :"+res[2].secncnt_val+'</span>')        
                               
                         }
                         
                
                         
                   },
                      error : function() {
                      alert('요청실패!');
                   }

                });

                        
                        });
                        

                        
                    }

                    // 이전달로 이동
                    $('.go-prev').on('click', function () {
                        thisMonth = new Date(currentYear, currentMonth - 1, 1);
                        renderCalender(thisMonth);
                    });

                    // 다음달로 이동
                    $('.go-next').on('click', function () {
                        thisMonth = new Date(currentYear, currentMonth + 1, 1);
                        renderCalender(thisMonth);
                        
                    });

                    
                    

            }

                



            </script>


<!-- Code injected by live-server -->
<script type="text/javascript">
   // <![CDATA[  <-- For SVG support
   if ('WebSocket' in window) {
      (function () {
         function refreshCSS() {
            var sheets = [].slice.call(document.getElementsByTagName("link"));
            var head = document.getElementsByTagName("head")[0];
            for (var i = 0; i < sheets.length; ++i) {
               var elem = sheets[i];
               var parent = elem.parentElement || head;
               parent.removeChild(elem);
               var rel = elem.rel;
               if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                  var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                  elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
               }
               parent.appendChild(elem);
            }
         }
         var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
         var address = protocol + window.location.host + window.location.pathname + '/ws';
         var socket = new WebSocket(address);
         socket.onmessage = function (msg) {
            if (msg.data == 'reload') window.location.reload();
            else if (msg.data == 'refreshcss') refreshCSS();
         };
         if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
            console.log('Live reload enabled.');
            sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
         }
      })();
   }
   else {
      console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
   }
   // ]]>
</script></body>

</html>