/**
 * Created by StevenWu on 17/4/13.
 */


function weather(){
    jQuery.ajax({
        url: 'https://free-api.heweather.com/v5/now?city=CN101190401&key=4835080919b8496e88c4d31d81ff19c7',
        type: 'post',
        dataType: 'json',

        success: function (data) {
         var tem = data.HeWeather5;
            var object = tem[0];
         appendNow(object.now.cond.txt,object.now.tmp,object.now.fl,object.now.hum,object.basic.update.loc);

        },
        error:function(data){
            swal("OMG", "服务器错误,请稍后重试!", "error");
        }
    });
}



function futureWeather(){
    jQuery.ajax({
        url: 'https://free-api.heweather.com/v5/forecast?city=CN101190401&key=4835080919b8496e88c4d31d81ff19c7',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            var tem = data.HeWeather5;
            var object = tem[0].daily_forecast;
            appendFuture(object[0].date,object[0].cond.txt_d,object[0].cond.txt_n,object[0].tmp.max+"~"+object[0].tmp.min,
                object[1].date,object[1].cond.txt_d,object[1].cond.txt_n,object[1].tmp.max+"~"+object[1].tmp.min,
                object[2].date,object[2].cond.txt_d,object[2].cond.txt_n,object[2].tmp.max+"~"+object[2].tmp.min)

        },
        error:function(data){
            swal("OMG", "服务器错误,请稍后重试!", "error");
        }
    });
}

function appendNow(txt,tmp,fl,hum,update){
    var result = "<h2 class='major'>苏州今天天气</h2>" +
        " <p>天气情况:${txt}</p> <p>温度:${tmp}℃</p> " +
        "<p>体感温度:${fl}℃</p> <p>相对湿度:${hum}%</p>" +
        " <p style='font-size: 3px'>数据最新更新时间:${update}</p>";
    $.tmpl(result, {
        txt: txt,
        tmp: tmp,
        fl: fl,
        hum: hum,
        update: update
    }).appendTo($('#nowWeather'));

}


function appendFuture(day1_date,day1_txt_d,day1_txt_n,day1_tmp,day2_date,day2_txt_d,day2_txt_n,day2_tmp,day3_date,day3_txt_d,day3_txt_n,day3_tmp){
    var result = "<h2 class='major'>接下来几天天气情况</h2> " +
        "<h4 class='major'>${day1_date}</h4> " +
        "<p>白天:${day1_txt_d}  夜间:${day1_txt_n} 气温:${day1_tmp}℃</p> " +
        "<h4 class='major'>${day2_date}</h4> " +
        "<p>白天:${day2_txt_d}  夜间:${day2_txt_n} 气温:${day2_tmp}℃</p> "+
        "<h4 class='major'>${day3_date}</h4> " +
        "<p>白天:${day3_txt_d}  夜间:${day3_txt_n} 气温:${day3_tmp}℃</p> ";
    $.tmpl(result, {
        day1_date:day1_date,
        day1_txt_d:day1_txt_d,
        day1_txt_n:day1_txt_n,
        day1_tmp:day1_tmp,
        day2_date:day2_date,
        day2_txt_d:day2_txt_d,
        day2_txt_n:day2_txt_n,
        day2_tmp:day2_tmp,
        day3_date:day3_date,
        day3_txt_d:day3_txt_d,
        day3_txt_n:day3_txt_n,
        day3_tmp:day3_tmp
    }).appendTo($('#futureWeather'));

}
