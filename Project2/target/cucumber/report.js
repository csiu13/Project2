$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/revature/cucumber/loginOutline.feature");
formatter.feature({
  "line": 1,
  "name": "login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "",
  "description": "",
  "id": "login;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "the application is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "valid \u003cusername\u003e and \u003cpassword\u003e are entered",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user clicks the login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user should be able to gain access to the application",
  "keyword": "Then "
});
formatter.examples({
  "line": 15,
  "name": "",
  "description": "",
  "id": "login;;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 16,
      "id": "login;;;1"
    },
    {
      "cells": [
        "\"svp@revature.com\"",
        "\"p@$$w0rd\""
      ],
      "line": 17,
      "id": "login;;;2"
    },
    {
      "cells": [
        "\"test.trainer@revature.com\"",
        "\"p@$$w0rd\""
      ],
      "line": 18,
      "id": "login;;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "User navigates to Assignforce homepage Given\nuser is on login page",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 17,
  "name": "",
  "description": "",
  "id": "login;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "the application is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "valid \"svp@revature.com\" and \"p@$$w0rd\" are entered",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user clicks the login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user should be able to gain access to the application",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Login.the_application_is_opened()"
});
formatter.result({
  "duration": 7600623472,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "svp@revature.com",
      "offset": 7
    },
    {
      "val": "p@$$w0rd",
      "offset": 30
    }
  ],
  "location": "GC_Login.valid_and_are_entered(String,String)"
});
formatter.result({
  "duration": 2115042307,
  "status": "passed"
});
formatter.match({
  "location": "GC_Login.the_user_clicks_the_login_button()"
});
formatter.result({
  "duration": 156146474,
  "status": "passed"
});
formatter.match({
  "location": "GC_Login.the_user_should_be_able_to_gain_access_to_the_application()"
});
formatter.result({
  "duration": 905838214,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "User navigates to Assignforce homepage Given\nuser is on login page",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 18,
  "name": "",
  "description": "",
  "id": "login;;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "the application is opened",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "valid \"test.trainer@revature.com\" and \"p@$$w0rd\" are entered",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the user clicks the login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "the user should be able to gain access to the application",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Login.the_application_is_opened()"
});
formatter.result({
  "duration": 6995507775,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test.trainer@revature.com",
      "offset": 7
    },
    {
      "val": "p@$$w0rd",
      "offset": 39
    }
  ],
  "location": "GC_Login.valid_and_are_entered(String,String)"
});
formatter.result({
  "duration": 1845244721,
  "status": "passed"
});
formatter.match({
  "location": "GC_Login.the_user_clicks_the_login_button()"
});
formatter.result({
  "duration": 144962797,
  "status": "passed"
});
formatter.match({
  "location": "GC_Login.the_user_should_be_able_to_gain_access_to_the_application()"
});
formatter.result({
  "duration": 746486673,
  "status": "passed"
});
});