$( document ).ready(
$(function () {
    $('#tasks').DataTable()
    $('[id^=taskClose]').click(
        function(){
          var id = $(this).attr('id').replace('taskClose','');
          if (confirm("Выполнить задачу "+id+"?")) {
            $.post(
              "task/executor/done.jsp",
              {
                taskId: id
              }
            ).done(function() { location.reload(); })
               .fail(function(data) { alert("Ошибка выполнения"); })
               .always(function() { alert("Задача "+id+" выполнена."); });
           }
        }
    )

    $('#daterange-btn').daterangepicker(
        {
          ranges   : {
            'Неделя' : [moment().startOf('week'), moment().endOf('week')],
            'Месяц'  : [moment().startOf('month'), moment().endOf('month')],
            'Год' : [moment().startOf('year'), moment().endOf('year')],
          },
          startDate: moment().subtract(10, 'days'),
          endDate  : moment()
        },
        function (start, end) {
          $('#daterange-btn span').html(start.format('DD.MM.YYYY') + ' - ' + end.format('DD.MM.YYYY'))
          $('#fromDate').val(start.format('DD.MM.YYYY'));
          $('#toDate').val(end.format('DD.MM.YYYY'));
          $('#taskFilter').submit();
        }
    )

    $('[id^=taskAdd]').click(
        function(){
          if (confirm("Добавить задачу?")) {
            $.post(
              "task/executor/add.jsp",
               $.param($('[id=formTaskAdd]').serializeArray())
            ).done(function() { location.reload(); })
               .fail(function(data) { alert("Ошибка выполнения"); })
               .always(function() { alert("Задача добавлена."); });
           }
        }
    )
})
);