if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'client'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'client'.");
}
var client = function (_, Kotlin) {
  'use strict';
  var Regex_init = Kotlin.kotlin.text.Regex_init_61zpoe$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var throwCCE = Kotlin.throwCCE;
  var Unit = Kotlin.kotlin.Unit;
  var EventListener = Kotlin.org.w3c.dom.events.EventListener_gbr1zf$;
  var ensureNotNull = Kotlin.ensureNotNull;
  var split = Kotlin.kotlin.text.split_ip8yn$;
  var toInt = Kotlin.kotlin.text.toInt_pdl1vz$;
  var toMutableList = Kotlin.kotlin.collections.toMutableList_4c7yge$;
  var joinToString = Kotlin.kotlin.collections.joinToString_fmv235$;
  var toList = Kotlin.kotlin.sequences.toList_veqyi0$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  function main$lambda$lambda(closure$start, closure$handler) {
    return function (it) {
      println(closure$start.value);
      closure$handler.addAgenda_61zpoe$(closure$start.value);
      return Unit;
    };
  }
  function main$lambda$lambda_0(closure$handler) {
    return function (it) {
      closure$handler.allTasks();
      return Unit;
    };
  }
  function main$lambda$lambda_1(closure$handler) {
    return function (it) {
      closure$handler.allDays();
      return Unit;
    };
  }
  function main$lambda$lambda$lambda(closure$handler, closure$date, closure$agendaID, closure$buttonID) {
    return function (it) {
      closure$handler.addDayToWeek_6hosri$(closure$date, ensureNotNull(closure$agendaID.textContent), closure$buttonID);
      return Unit;
    };
  }
  function main$lambda$lambda_2(closure$handler, closure$status, closure$description, closure$time, closure$dayIdText) {
    return function (it) {
      closure$handler.addTaskToDay_puj7f4$(closure$status.value + ';;' + closure$description.value + ';;' + closure$time.value, closure$dayIdText);
      return Unit;
    };
  }
  function main$lambda$lambda_3(closure$handler) {
    return function (it) {
      var r = Regex_init('\\d+');
      var m = toList(r.findAll_905azu$(window.location.pathname));
      closure$handler.addStatus_puj7f4$(m.get_za3lpa$(0).groupValues.get_za3lpa$(0), m.get_za3lpa$(1).groupValues.get_za3lpa$(0));
      return Unit;
    };
  }
  function main$lambda$lambda_4(closure$handler) {
    return function (it) {
      var r = Regex_init('\\d+');
      var m = toList(r.findAll_905azu$(window.location.pathname));
      closure$handler.chStatus_puj7f4$(m.get_za3lpa$(0).groupValues.get_za3lpa$(0), m.get_za3lpa$(1).groupValues.get_za3lpa$(0));
      return Unit;
    };
  }
  function main$lambda$lambda_5(closure$handler, closure$newTime) {
    return function (it) {
      var r = Regex_init('\\d+');
      var m = toList(r.findAll_905azu$(window.location.pathname));
      closure$handler.chTime_6hosri$(m.get_za3lpa$(0).groupValues.get_za3lpa$(0), m.get_za3lpa$(1).groupValues.get_za3lpa$(0), closure$newTime.value);
      return Unit;
    };
  }
  function main$lambda$lambda_6(closure$handler) {
    return function (it) {
      println('delStatus');
      var r = Regex_init('\\d+');
      var m = toList(r.findAll_905azu$(window.location.pathname));
      closure$handler.delStatus_puj7f4$(m.get_za3lpa$(0).groupValues.get_za3lpa$(0), m.get_za3lpa$(1).groupValues.get_za3lpa$(0));
      return Unit;
    };
  }
  function main$lambda$lambda_7(closure$handler) {
    return function (it) {
      var r = Regex_init('\\d+');
      var m = toList(r.findAll_905azu$(window.location.pathname));
      closure$handler.delTask_puj7f4$(m.get_za3lpa$(0).groupValues.get_za3lpa$(0), m.get_za3lpa$(1).groupValues.get_za3lpa$(0));
      return Unit;
    };
  }
  var Array_0 = Array;
  function main$lambda(it) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5, tmp$_6, tmp$_7, tmp$_8, tmp$_9, tmp$_10, tmp$_11, tmp$_12, tmp$_13, tmp$_14, tmp$_15, tmp$_16;
    var handler = new Caller();
    var regMain = Regex_init('http://127\\.0\\.0\\.1:8082/agendas/?');
    var regAgenda = Regex_init('http://127\\.0\\.0\\.1:8082/agendas/[0-9]+/days/?');
    var regDay = Regex_init('http://127\\.0\\.0\\.1:8082/agendas/[0-9]+/days/[0-9]+/?');
    var regDayTask = Regex_init('http://127\\.0\\.0\\.1:8082/days/[0-9]+/tasks/[0-9]+/?');
    var regTask = Regex_init('http://127\\.0\\.0\\.1:8082/tasks/\\d+/?');
    println(window.document.URL);
    var $receiver = window.document.URL;
    if (regMain.matches_6bul2c$($receiver)) {
      println('matched regMain');
      var start = Kotlin.isType(tmp$ = document.getElementById('start'), HTMLInputElement) ? tmp$ : throwCCE();
      var newAgenda = Kotlin.isType(tmp$_0 = document.getElementById('addAgenda'), HTMLButtonElement) ? tmp$_0 : throwCCE();
      var allTasks = Kotlin.isType(tmp$_1 = document.getElementById('allTasks'), HTMLButtonElement) ? tmp$_1 : throwCCE();
      var allDays = Kotlin.isType(tmp$_2 = document.getElementById('allDays'), HTMLButtonElement) ? tmp$_2 : throwCCE();
      newAgenda.addEventListener('click', EventListener(main$lambda$lambda(start, handler)));
      allTasks.addEventListener('click', EventListener(main$lambda$lambda_0(handler)));
      allDays.addEventListener('click', EventListener(main$lambda$lambda_1(handler)));
    }
     else {
      var $receiver_0 = window.document.URL;
      if (regAgenda.matches_6bul2c$($receiver_0)) {
        println('matched regAgenda');
        var elements = document.getElementsByTagName('button');
        var array = Array_0(elements.length);
        var tmp$_17;
        tmp$_17 = array.length - 1 | 0;
        for (var i = 0; i <= tmp$_17; i++) {
          var tmp$_18;
          array[i] = Kotlin.isType(tmp$_18 = elements[i], HTMLButtonElement) ? tmp$_18 : throwCCE();
        }
        var buttons = array;
        var agendaID = Kotlin.isType(tmp$_3 = document.getElementById('agendaID'), HTMLLabelElement) ? tmp$_3 : throwCCE();
        var start_0 = Kotlin.isType(tmp$_4 = document.getElementById('label'), HTMLLabelElement) ? tmp$_4 : throwCCE();
        var startDate = split(ensureNotNull(start_0.textContent), ['-']);
        agendaID.hidden = true;
        start_0.hidden = true;
        var tmp$_19;
        for (tmp$_19 = 0; tmp$_19 !== buttons.length; ++tmp$_19) {
          var element = buttons[tmp$_19];
          var buttonID = element.id;
          var day = toInt(startDate.get_za3lpa$(2)) + toInt(buttonID) | 0;
          var newDate = toMutableList(startDate);
          newDate.set_wxm5ur$(2, day.toString());
          var date = joinToString(newDate, '-');
          element.addEventListener('click', EventListener(main$lambda$lambda$lambda(handler, date, agendaID, buttonID)));
        }
      }
       else {
        var $receiver_1 = window.document.URL;
        if (regDay.matches_6bul2c$($receiver_1)) {
          println('matched regDay');
          var status = Kotlin.isType(tmp$_5 = document.getElementById('status'), HTMLInputElement) ? tmp$_5 : throwCCE();
          var description = Kotlin.isType(tmp$_6 = document.getElementById('description'), HTMLInputElement) ? tmp$_6 : throwCCE();
          var time = Kotlin.isType(tmp$_7 = document.getElementById('time'), HTMLInputElement) ? tmp$_7 : throwCCE();
          var button = Kotlin.isType(tmp$_8 = document.getElementById('addTask'), HTMLButtonElement) ? tmp$_8 : throwCCE();
          var dayID = Kotlin.isType(tmp$_9 = document.getElementById('dayID'), HTMLLabelElement) ? tmp$_9 : throwCCE();
          dayID.hidden = true;
          var dayIdText = typeof (tmp$_10 = dayID.textContent) === 'string' ? tmp$_10 : throwCCE();
          button.addEventListener('click', EventListener(main$lambda$lambda_2(handler, status, description, time, dayIdText)));
        }
         else {
          var $receiver_2 = window.document.URL;
          var tmp$_20 = regTask.matches_6bul2c$($receiver_2);
          if (!tmp$_20) {
            var $receiver_3 = window.document.URL;
            tmp$_20 = regDayTask.matches_6bul2c$($receiver_3);
          }
          if (tmp$_20) {
            println('matched regTask');
            var addStatus = Kotlin.isType(tmp$_11 = document.getElementById('addStatus'), HTMLButtonElement) ? tmp$_11 : throwCCE();
            var chStatus = Kotlin.isType(tmp$_12 = document.getElementById('chStatus'), HTMLButtonElement) ? tmp$_12 : throwCCE();
            var delStatus = Kotlin.isType(tmp$_13 = document.getElementById('delStatus'), HTMLButtonElement) ? tmp$_13 : throwCCE();
            var chTime = Kotlin.isType(tmp$_14 = document.getElementById('chTime'), HTMLButtonElement) ? tmp$_14 : throwCCE();
            var delTask = Kotlin.isType(tmp$_15 = document.getElementById('delTask'), HTMLButtonElement) ? tmp$_15 : throwCCE();
            var newTime = Kotlin.isType(tmp$_16 = document.getElementById('newTime'), HTMLInputElement) ? tmp$_16 : throwCCE();
            addStatus.addEventListener('click', EventListener(main$lambda$lambda_3(handler)));
            chStatus.addEventListener('click', EventListener(main$lambda$lambda_4(handler)));
            chTime.addEventListener('click', EventListener(main$lambda$lambda_5(handler, newTime)));
            delStatus.addEventListener('click', EventListener(main$lambda$lambda_6(handler)));
            delTask.addEventListener('click', EventListener(main$lambda$lambda_7(handler)));
          }
        }
      }
    }
    return 'OK';
  }
  function main() {
    window.onload = main$lambda;
  }
  function Caller() {
  }
  function Caller$allTasks$lambda(it) {
    return Unit;
  }
  Caller.prototype.allTasks = function () {
    HTTPClient_getInstance().get_a05nzl$('/tasks', void 0, Caller$allTasks$lambda);
  };
  function Caller$allDays$lambda(it) {
    return Unit;
  }
  Caller.prototype.allDays = function () {
    HTTPClient_getInstance().get_a05nzl$('/days', void 0, Caller$allDays$lambda);
  };
  function Caller$addAgenda$lambda(it) {
    println('received: ' + '"' + it + '"');
    return Unit;
  }
  Caller.prototype.addAgenda_61zpoe$ = function (start) {
    println('addAgenda, start: ' + start);
    HTTPClient_getInstance().post_i885h9$('/agendas', start, void 0, Caller$addAgenda$lambda);
  };
  function Caller$addTaskToDay$lambda(it) {
    return Unit;
  }
  Caller.prototype.addTaskToDay_puj7f4$ = function (taskString, dayID) {
    println(taskString);
    HTTPClient_getInstance().post_i885h9$('/days/' + dayID + '/tasks', taskString + ';;/days/' + dayID, void 0, Caller$addTaskToDay$lambda);
  };
  function Caller$addDayToWeek$lambda(it) {
    return Unit;
  }
  function Caller$addDayToWeek$lambda_0(it) {
    return Unit;
  }
  Caller.prototype.addDayToWeek_6hosri$ = function (dayString, agendaID, dayID) {
    HTTPClient_getInstance().post_i885h9$('/days', dayString, void 0, Caller$addDayToWeek$lambda);
    HTTPClient_getInstance().post_i885h9$('/agendas/' + agendaID + '/days', dayString + ';;' + dayID, void 0, Caller$addDayToWeek$lambda_0);
  };
  function Caller$delTask$lambda(it) {
    return Unit;
  }
  Caller.prototype.delTask_puj7f4$ = function (dayID, taskID) {
    HTTPClient_getInstance().delete_a05nzl$('/days/' + dayID + '/tasks/' + taskID, void 0, Caller$delTask$lambda);
  };
  function Caller$delStatus$lambda(it) {
    return Unit;
  }
  Caller.prototype.delStatus_puj7f4$ = function (dayID, taskID) {
    println('id: ' + taskID);
    HTTPClient_getInstance().delete_a05nzl$('/days/' + dayID + '/tasks/' + taskID + '/status', void 0, Caller$delStatus$lambda);
  };
  function Caller$addStatus$lambda(it) {
    return Unit;
  }
  Caller.prototype.addStatus_puj7f4$ = function (dayID, taskID) {
    HTTPClient_getInstance().post_i885h9$('/days/' + dayID + '/tasks/' + taskID + '/status', 'TODO', void 0, Caller$addStatus$lambda);
  };
  function Caller$chStatus$lambda(it) {
    return Unit;
  }
  Caller.prototype.chStatus_puj7f4$ = function (dayID, taskID) {
    HTTPClient_getInstance().put_i885h9$('/days/' + dayID + '/tasks/' + taskID + '/status', 'DONE', void 0, Caller$chStatus$lambda);
  };
  function Caller$chTime$lambda(it) {
    return Unit;
  }
  Caller.prototype.chTime_6hosri$ = function (dayID, taskID, newTime) {
    HTTPClient_getInstance().put_i885h9$('/days/' + dayID + '/tasks/' + taskID + '/time', newTime, void 0, Caller$chTime$lambda);
  };
  Caller.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'Caller',
    interfaces: []
  };
  function HTTPClient() {
    HTTPClient_instance = this;
  }
  function HTTPClient$get$lambda(closure$call, closure$xhttp) {
    return function (it) {
      closure$call(closure$xhttp.responseText);
      return Unit;
    };
  }
  HTTPClient.prototype.get_a05nzl$ = function (url, header, call) {
    if (header === void 0)
      header = 'application/json';
    var xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.setRequestHeader('Accept', header);
    xhttp.onload = HTTPClient$get$lambda(call, xhttp);
    xhttp.send();
  };
  function HTTPClient$post$lambda(closure$call, closure$xhttp) {
    return function (it) {
      closure$call(closure$xhttp.responseText);
      return Unit;
    };
  }
  HTTPClient.prototype.post_i885h9$ = function (url, body, header, call) {
    if (header === void 0)
      header = 'application/json';
    var xhttp = new XMLHttpRequest();
    xhttp.open('POST', url, true);
    xhttp.setRequestHeader('Content-Type', header);
    xhttp.setRequestHeader('Accept', header);
    xhttp.onload = HTTPClient$post$lambda(call, xhttp);
    xhttp.send(body);
  };
  function HTTPClient$put$lambda(closure$call, closure$xhttp) {
    return function (it) {
      closure$call(closure$xhttp.responseText);
      return Unit;
    };
  }
  HTTPClient.prototype.put_i885h9$ = function (url, body, header, call) {
    if (header === void 0)
      header = 'application/json';
    var xhttp = new XMLHttpRequest();
    xhttp.open('PUT', url, true);
    xhttp.setRequestHeader('Content-Type', header);
    xhttp.setRequestHeader('Accept', header);
    xhttp.onload = HTTPClient$put$lambda(call, xhttp);
    xhttp.send(body);
  };
  function HTTPClient$delete$lambda(closure$call, closure$xhttp) {
    return function (it) {
      closure$call(closure$xhttp.responseText);
      return Unit;
    };
  }
  HTTPClient.prototype.delete_a05nzl$ = function (url, header, call) {
    if (header === void 0)
      header = 'application/json';
    var xhttp = new XMLHttpRequest();
    xhttp.open('DELETE', url, true);
    xhttp.setRequestHeader('Accept', header);
    xhttp.onload = HTTPClient$delete$lambda(call, xhttp);
    xhttp.send();
  };
  HTTPClient.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'HTTPClient',
    interfaces: []
  };
  var HTTPClient_instance = null;
  function HTTPClient_getInstance() {
    if (HTTPClient_instance === null) {
      new HTTPClient();
    }
    return HTTPClient_instance;
  }
  _.main = main;
  _.Caller = Caller;
  Object.defineProperty(_, 'HTTPClient', {
    get: HTTPClient_getInstance
  });
  main();
  Kotlin.defineModule('client', _);
  return _;
}(typeof client === 'undefined' ? {} : client, kotlin);
