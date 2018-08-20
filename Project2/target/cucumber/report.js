$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/revature/cucumber/CreateBatchOutline.feature");
formatter.feature({
  "line": 1,
  "name": "login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "",
  "description": "",
  "id": "login;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \u003ccore\u003e, \u003cstart date\u003e, \u003ctrainer\u003e, \u003cco-trainer\u003e, \u003clocation\u003e, \u003cbuilding\u003e, and \u003croom\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "login;;",
  "rows": [
    {
      "cells": [
        "core",
        "start date",
        "trainer",
        "co-trainer",
        "location",
        "building",
        "room"
      ],
      "line": 10,
      "id": "login;;;1"
    },
    {
      "cells": [
        "\"Java\"",
        "\"today\"",
        "\"August\"",
        "\"Yuvi\"",
        "\"Revature\"",
        "\"HQ\"",
        "214"
      ],
      "line": 11,
      "id": "login;;;2"
    },
    {
      "cells": [
        "\"Java\"",
        "\"today\"",
        "\"Yuvi\"",
        "\"Peter\"",
        "\"Capital One\"",
        "\"Chicago\"",
        "208"
      ],
      "line": 12,
      "id": "login;;;3"
    },
    {
      "cells": [
        "\"Net\"",
        "\"today\"",
        "\"Yuvi\"",
        "\"Yuvi\"",
        "\"Capital One\"",
        "\"HQ\"",
        "208"
      ],
      "line": 13,
      "id": "login;;;4"
    },
    {
      "cells": [
        "\"Net\"",
        "\"today\"",
        "\"Peter\"",
        "\"Peter\"",
        "\"Revature\"",
        "\"HQ\"",
        "214"
      ],
      "line": 14,
      "id": "login;;;5"
    },
    {
      "cells": [
        "\"Net\"",
        "\"today\"",
        "\"Yuvi\"",
        "\"August\"",
        "\"Capital One\"",
        "\"Chicago\"",
        "208"
      ],
      "line": 15,
      "id": "login;;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "",
  "description": "",
  "id": "login;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \"Java\", \"today\", \"August\", \"Yuvi\", \"Revature\", \"HQ\", and 214",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Batch.the_user_navigates_to_the_batch_tab()"
});
formatter.result({
  "duration": 13838946089,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Java",
      "offset": 17
    },
    {
      "val": "today",
      "offset": 25
    },
    {
      "val": "August",
      "offset": 34
    },
    {
      "val": "Yuvi",
      "offset": 44
    },
    {
      "val": "Revature",
      "offset": 52
    },
    {
      "val": "HQ",
      "offset": 64
    },
    {
      "val": "214",
      "offset": 73
    }
  ],
  "location": "GC_Batch.the_user_inputs_and(String,String,String,String,String,String,int)"
});
formatter.result({
  "duration": 15418173989,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_user_clicks_the_cancel_button()"
});
formatter.result({
  "duration": 685311883,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_program_should_clear_all_fields()"
});
formatter.result({
  "duration": 2135356927,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "",
  "description": "",
  "id": "login;;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \"Java\", \"today\", \"Yuvi\", \"Peter\", \"Capital One\", \"Chicago\", and 208",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Batch.the_user_navigates_to_the_batch_tab()"
});
formatter.result({
  "duration": 13796999834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Java",
      "offset": 17
    },
    {
      "val": "today",
      "offset": 25
    },
    {
      "val": "Yuvi",
      "offset": 34
    },
    {
      "val": "Peter",
      "offset": 42
    },
    {
      "val": "Capital One",
      "offset": 51
    },
    {
      "val": "Chicago",
      "offset": 66
    },
    {
      "val": "208",
      "offset": 80
    }
  ],
  "location": "GC_Batch.the_user_inputs_and(String,String,String,String,String,String,int)"
});
formatter.result({
  "duration": 16669816994,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_user_clicks_the_cancel_button()"
});
formatter.result({
  "duration": 734410522,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_program_should_clear_all_fields()"
});
formatter.result({
  "duration": 2140826534,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "",
  "description": "",
  "id": "login;;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \"Net\", \"today\", \"Yuvi\", \"Yuvi\", \"Capital One\", \"HQ\", and 208",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Batch.the_user_navigates_to_the_batch_tab()"
});
formatter.result({
  "duration": 14122392967,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Net",
      "offset": 17
    },
    {
      "val": "today",
      "offset": 24
    },
    {
      "val": "Yuvi",
      "offset": 33
    },
    {
      "val": "Yuvi",
      "offset": 41
    },
    {
      "val": "Capital One",
      "offset": 49
    },
    {
      "val": "HQ",
      "offset": 64
    },
    {
      "val": "208",
      "offset": 73
    }
  ],
  "location": "GC_Batch.the_user_inputs_and(String,String,String,String,String,String,int)"
});
formatter.result({
  "duration": 16086328267,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_user_clicks_the_cancel_button()"
});
formatter.result({
  "duration": 803601245,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_program_should_clear_all_fields()"
});
formatter.result({
  "duration": 2154723555,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "",
  "description": "",
  "id": "login;;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \"Net\", \"today\", \"Peter\", \"Peter\", \"Revature\", \"HQ\", and 214",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Batch.the_user_navigates_to_the_batch_tab()"
});
formatter.result({
  "duration": 11164654131,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Net",
      "offset": 17
    },
    {
      "val": "today",
      "offset": 24
    },
    {
      "val": "Peter",
      "offset": 33
    },
    {
      "val": "Peter",
      "offset": 42
    },
    {
      "val": "Revature",
      "offset": 51
    },
    {
      "val": "HQ",
      "offset": 63
    },
    {
      "val": "214",
      "offset": 72
    }
  ],
  "location": "GC_Batch.the_user_inputs_and(String,String,String,String,String,String,int)"
});
formatter.result({
  "duration": 15444208276,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_user_clicks_the_cancel_button()"
});
formatter.result({
  "duration": 681139697,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_program_should_clear_all_fields()"
});
formatter.result({
  "duration": 2150345629,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "",
  "description": "",
  "id": "login;;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "the user navigates to the batch tab",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user inputs \"Net\", \"today\", \"Yuvi\", \"August\", \"Capital One\", \"Chicago\", and 208",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the user clicks the cancel button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the program should clear all fields",
  "keyword": "Then "
});
formatter.match({
  "location": "GC_Batch.the_user_navigates_to_the_batch_tab()"
});
formatter.result({
  "duration": 10876900239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Net",
      "offset": 17
    },
    {
      "val": "today",
      "offset": 24
    },
    {
      "val": "Yuvi",
      "offset": 33
    },
    {
      "val": "August",
      "offset": 41
    },
    {
      "val": "Capital One",
      "offset": 51
    },
    {
      "val": "Chicago",
      "offset": 66
    },
    {
      "val": "208",
      "offset": 80
    }
  ],
  "location": "GC_Batch.the_user_inputs_and(String,String,String,String,String,String,int)"
});
formatter.result({
  "duration": 15855731868,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_user_clicks_the_cancel_button()"
});
formatter.result({
  "duration": 860879569,
  "status": "passed"
});
formatter.match({
  "location": "GC_Batch.the_program_should_clear_all_fields()"
});
formatter.result({
  "duration": 2140188786,
  "status": "passed"
});
});