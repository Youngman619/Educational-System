$(document).ready(function() {

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,basicWeek,basicDay'
        },
        defaultView:"basicWeek",
        defaultDate: '2019-07-26',
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        eventLimit: true, // allow "more" link when too many events
        displayEventEnd: true,
        timeFormat: 'HH:mm',
        events: function(start, end, timezone, callback){
            $.ajax({
                type: 'POST',
                url: '/schedule/selectAll',
                dataType: 'json',
                success: function(data){
                    var events = [];
                    $.each(data, function (index,value) {
                        var backgroundColor;
                        switch (value.lessontype){
                            case("0"):
                                backgroundColor = "#FFCC00";
                                break;
                            case("1"):
                                backgroundColor = "#FF99CC";
                                break;
                            case("2"):
                                backgroundColor = "#99CCFF";
                                break;
                            case("3"):
                                backgroundColor = "#66CC99";
                                break;
                            case("4"):
                                backgroundColor = "#FF6666";
                                break;
                            default:
                                backgroundColor = "#eef2f5";
                        }
                        events.push({
                            id: value.uuid,
                            title: "\n" + value.lesson.lessonname,
                            start: value.starttime,
                            end: value.endtime,
                            backgroundColor: backgroundColor
                        });
                    });
                    callback(events);
                },
                error: function(){
                    alert("error");
                }
            });
        },
        eventClick: function(event, jsEvent, view) {
            alert(event.id);
        },
        dayClick: function(date, allDay, jsEvent, view) {
            var events = $('#calendar').fullCalendar('clientEvents', function(event) {
                var eventStart = event.start.format('YYYY-MM-DD');
                var eventEnd = event.end ? event.end.format('YYYY-MM-DD') : null;
                var theDate = date.format('YYYY-MM-DD');
                return (eventStart <= theDate && (eventEnd >= theDate) && !(eventStart < theDate && (eventEnd == theDate))) || (eventStart == theDate && (eventEnd === null));
            });
            var currentView = $('#calendar').fullCalendar('getView');
            if(events.length < 4 && currentView.name == "basicWeek"){
                $('#addScheduleModal').modal('show');
                var currentDate = date.format();
                $("#currentDate").val(currentDate);
            }
        }
    });
});