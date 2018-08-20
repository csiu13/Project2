var app = angular.module('reportingApp', []);

app.controller('ScreenshotReportController', function ($scope) {
    $scope.searchSettings = Object.assign({
        description: '',
        allselected: true,
        passed: true,
        failed: true,
        pending: true,
        withLog: true,
    },{}); // enable customisation of search settings on first page hit

    var initialColumnSettings=undefined; // enable customisation of visible columns on first page hit
    if(initialColumnSettings) {
        if(initialColumnSettings.displayTime !==undefined) {
            this.displayTime=!initialColumnSettings.displayTime; // initial settings have be inverted because the html bindings are inverted (e.g. !ctrl.displayTime)
        }
        if(initialColumnSettings.displayBrowser !==undefined) {
            this.displayBrowser=!initialColumnSettings.displayBrowser; // same as above
        }
        if(initialColumnSettings.displaySessionId !== undefined) {
            this.displaySessionId=!initialColumnSettings.displaySessionId; // same as above
        }
        if(initialColumnSettings.displaySessionId !== undefined) {
            this.displaySessionId=!initialColumnSettings.displaySessionId; // same as above
        }
        if(initialColumnSettings.inlineScreenshots !== undefined) {
            this.inlineScreenshots=initialColumnSettings.inlineScreenshots; // this setting does not have to be inverted
        }

    }


    $scope.inlineScreenshots = false;
    this.showSmartStackTraceHighlight = true;

    this.chooseAllTypes = function () {
        var value = true;
        $scope.searchSettings.allselected = !$scope.searchSettings.allselected;
        if (!$scope.searchSettings.allselected) {
            value = false;
        }

        $scope.searchSettings.passed = value;
        $scope.searchSettings.failed = value;
        $scope.searchSettings.pending = value;
        $scope.searchSettings.withLog = value;
    };

    this.getParent = function (str) {
        var arr = str.split('|');
        str = "";
        for (var i = arr.length - 2; i > 0; i--) {
            str += arr[i] + " > ";
        }
        return str.slice(0, -3);
    };

    this.specLevel = function (str) {
        var arr = str.split('|');
        str = "";
        if (arr.length < 3) {
            return true;
        }
        return false;
    };

    this.getSpec = function (str) {
        return getSpec(str);
    };


    this.getShortDescription = function (str) {
        return str.split('|')[0];
    };


    this.nToBr = function (str) {
        return str.replace(/(?:\r\n|\r|\n)/g, '<br />');
    };


    this.convertTimestamp = function (timestamp) {
        var d = new Date(timestamp),
            yyyy = d.getFullYear(),
            mm = ('0' + (d.getMonth() + 1)).slice(-2),
            dd = ('0' + d.getDate()).slice(-2),
            hh = d.getHours(),
            h = hh,
            min = ('0' + d.getMinutes()).slice(-2),
            ampm = 'AM',
            time;

        if (hh > 12) {
            h = hh - 12;
            ampm = 'PM';
        } else if (hh === 12) {
            h = 12;
            ampm = 'PM';
        } else if (hh == 0) {
            h = 12;
        }

        // ie: 2013-02-18, 8:35 AM
        time = yyyy + '-' + mm + '-' + dd + ', ' + h + ':' + min + ' ' + ampm;

        return time;
    };


    this.round = function (number, roundVal) {
        return (parseFloat(number)/1000).toFixed(roundVal);
    };


    this.passCount = function () {
        var passCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (result.passed) {passCount++};
        }
        return passCount;
    };


    this.pendingCount = function () {
        var pendingCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (result.pending) {pendingCount++};
        }
        return pendingCount;
    };


    this.failCount = function () {
        var failCount = 0;
        for (var i in this.results) {
            var result = this.results[i];
            if (!result.passed && !result.pending) {failCount++}
        }
        return failCount;
    };

    this.applySmartHighlight = function (line) {
        if (this.showSmartStackTraceHighlight) {
            if (line.indexOf('node_modules') > -1) {
                return 'greyout';
            }
            if (line.indexOf('  at ') === -1) {
                return '';
            }

            return 'highlight';
        }
        return true;
    };


    var results =[
    {
        "description": "should have a title|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00fe004c-0072-0091-00c9-006900fc00c6.png",
        "timestamp": 1534728323656,
        "duration": 13544
    },
    {
        "description": "should have a login widget|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed",
        "browserLogs": [],
        "screenShotFile": "00030042-0025-00f7-0041-00a800a100ac.png",
        "timestamp": 1534728337695,
        "duration": 26
    },
    {
        "description": "it should be able to login (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/72d2ed354468e51d557d8dd7a3111f66?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728338993,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/72d2ed354468e51d557d8dd7a3111f66.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728343998,
                "type": ""
            }
        ],
        "screenShotFile": "00da0095-00df-00ad-0056-001f008400ad.png",
        "timestamp": 1534728338106,
        "duration": 5899
    },
    {
        "description": "it should be able to logout (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728347362,
                "type": ""
            }
        ],
        "screenShotFile": "00c600ce-00b0-0075-0059-00ce00030057.png",
        "timestamp": 1534728344254,
        "duration": 3844
    },
    {
        "description": "it should be able to login (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728352281,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728357296,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728357298,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728357299,
                "type": ""
            }
        ],
        "screenShotFile": "00ab00c2-0029-00f5-0039-00d9002d0046.png",
        "timestamp": 1534728348430,
        "duration": 8884
    },
    {
        "description": "it should be able to logout (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728360888,
                "type": ""
            }
        ],
        "screenShotFile": "00f30029-0084-00ac-0080-00cb001600a7.png",
        "timestamp": 1534728357670,
        "duration": 5657
    },
    {
        "description": "overview should be on the overview page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728369130,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534728369130,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728369132,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534728369133,
                "type": ""
            }
        ],
        "screenShotFile": "00040023-00ec-0096-003b-008d00d10006.png",
        "timestamp": 1534728363699,
        "duration": 5664
    },
    {
        "description": "batches should be on the batches page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370381,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370391,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370407,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370411,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370414,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370417,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370424,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370899,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370920,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534728370925,
                "type": ""
            }
        ],
        "screenShotFile": "0045003c-005d-000b-0039-0033007f0040.png",
        "timestamp": 1534728369708,
        "duration": 6717
    },
    {
        "description": "locations should be on the locations page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "0007008f-0056-00a5-0089-00fb00da00a3.png",
        "timestamp": 1534728377196,
        "duration": 701
    },
    {
        "description": "curricula should be on the curricula page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "009e00de-0004-00b9-00db-008200be0045.png",
        "timestamp": 1534728378177,
        "duration": 135
    },
    {
        "description": "trainers should be on the trainers page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00800090-00a3-00bb-0081-0033000f00b7.png",
        "timestamp": 1534728378621,
        "duration": 147
    },
    {
        "description": "report tab is broken|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00bb0037-00fb-00f5-0003-009c00c100ef.png",
        "timestamp": 1534728379099,
        "duration": 235
    },
    {
        "description": "settings tab goes to reports|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c47434615caecc4417ab1317724a1e19",
        "instanceId": 31268,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "004c004e-0049-00c2-005d-004200c800c1.png",
        "timestamp": 1534728379643,
        "duration": 416
    },
    {
        "description": "should have a title|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "003c002b-0053-0075-00fe-009400a200ba.png",
        "timestamp": 1534740297305,
        "duration": 12510
    },
    {
        "description": "should have a login widget|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed",
        "browserLogs": [],
        "screenShotFile": "001e0043-00be-0032-0097-00e900c00098.png",
        "timestamp": 1534740310510,
        "duration": 40
    },
    {
        "description": "it should be able to login (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/72d2ed354468e51d557d8dd7a3111f66?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740316549,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/72d2ed354468e51d557d8dd7a3111f66.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740316549,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740316553,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740316553,
                "type": ""
            }
        ],
        "screenShotFile": "002c00e1-00b1-0035-00c8-00f000850033.png",
        "timestamp": 1534740310893,
        "duration": 5695
    },
    {
        "description": "it should be able to logout (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740319938,
                "type": ""
            }
        ],
        "screenShotFile": "002b0054-002f-006b-0093-0059000800ed.png",
        "timestamp": 1534740316815,
        "duration": 3601
    },
    {
        "description": "it should be able to login (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740329242,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740329242,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740329244,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740329244,
                "type": ""
            }
        ],
        "screenShotFile": "002000f3-00e9-006a-0015-008c00a40082.png",
        "timestamp": 1534740320756,
        "duration": 8494
    },
    {
        "description": "it should be able to logout (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534740332666,
                "type": ""
            }
        ],
        "screenShotFile": "00370020-0015-00d2-0050-006200ce00eb.png",
        "timestamp": 1534740329519,
        "duration": 5459
    },
    {
        "description": "overview should be on the overview page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740340669,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534740340669,
                "type": ""
            }
        ],
        "screenShotFile": "00e30052-0037-008a-004e-00c700dc0018.png",
        "timestamp": 1534740335312,
        "duration": 5435
    },
    {
        "description": "batches should be on the batches page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341169,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341170,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341173,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341173,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341174,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341175,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341175,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341292,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341295,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534740341295,
                "type": ""
            }
        ],
        "screenShotFile": "00250020-0078-001b-00d1-0094007c007b.png",
        "timestamp": 1534740341004,
        "duration": 2227
    },
    {
        "description": "locations should be on the locations page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "001900a9-0063-0002-0075-00ba00fb0089.png",
        "timestamp": 1534740343525,
        "duration": 491
    },
    {
        "description": "curricula should be on the curricula page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00bd0046-0093-00ec-0078-00c000bf0007.png",
        "timestamp": 1534740344322,
        "duration": 124
    },
    {
        "description": "trainers should be on the trainers page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00970085-00bf-0002-0090-00fa0055000a.png",
        "timestamp": 1534740344717,
        "duration": 120
    },
    {
        "description": "report tab is broken|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "0086008c-0021-0045-00f5-0005008c0056.png",
        "timestamp": 1534740345141,
        "duration": 165
    },
    {
        "description": "settings tab goes to reports|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "c89d4784cbf7406a3889adb98e971215",
        "instanceId": 11584,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00a40088-0081-0057-00de-00ee00260088.png",
        "timestamp": 1534740345828,
        "duration": 298
    },
    {
        "description": "should have a title|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00b00023-00ed-00c4-0074-003700c90008.png",
        "timestamp": 1534742907562,
        "duration": 13941
    },
    {
        "description": "should have a login widget|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed",
        "browserLogs": [],
        "screenShotFile": "0035006f-0007-0012-000f-000b00cd0034.png",
        "timestamp": 1534742921881,
        "duration": 19
    },
    {
        "description": "it should be able to login (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/72d2ed354468e51d557d8dd7a3111f66?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742928981,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/72d2ed354468e51d557d8dd7a3111f66.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742928982,
                "type": ""
            }
        ],
        "screenShotFile": "002f0095-0040-007c-007b-008b00d400fa.png",
        "timestamp": 1534742923449,
        "duration": 5555
    },
    {
        "description": "it should be able to logout (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534742932418,
                "type": ""
            }
        ],
        "screenShotFile": "00380048-00a2-0028-0086-00aa00810034.png",
        "timestamp": 1534742929289,
        "duration": 3617
    },
    {
        "description": "it should be able to login (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742941670,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742941671,
                "type": ""
            }
        ],
        "screenShotFile": "000c0012-00ba-00eb-00af-000e00af0074.png",
        "timestamp": 1534742933256,
        "duration": 8420
    },
    {
        "description": "it should be able to logout (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:873286 \"ERROR\"",
                "timestamp": 1534742945096,
                "type": ""
            }
        ],
        "screenShotFile": "00eb0096-00b5-0022-008b-003b009d00ce.png",
        "timestamp": 1534742941947,
        "duration": 5476
    },
    {
        "description": "overview should be on the overview page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/avatar/7e20ee4b93ca68a3a2d4f0fd787fba95?d=404&s=160 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742953139,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534742953139,
                "type": ""
            }
        ],
        "screenShotFile": "009f0064-007d-0099-0067-00160036004b.png",
        "timestamp": 1534742947730,
        "duration": 5529
    },
    {
        "description": "batches should be on the batches page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953742,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953745,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953748,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953749,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953750,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953751,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953752,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953868,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953875,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534742953876,
                "type": ""
            }
        ],
        "screenShotFile": "00a0003f-005f-004d-001b-00d50058003d.png",
        "timestamp": 1534742953550,
        "duration": 2011
    },
    {
        "description": "locations should be on the locations page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00d2002c-002d-008b-000e-00cf005f0032.png",
        "timestamp": 1534742955969,
        "duration": 454
    },
    {
        "description": "curricula should be on the curricula page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "0091000e-0043-0017-00ca-0007007c008d.png",
        "timestamp": 1534742956711,
        "duration": 150
    },
    {
        "description": "trainers should be on the trainers page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "000f000f-002f-00ab-0007-006a003c003d.png",
        "timestamp": 1534742957169,
        "duration": 132
    },
    {
        "description": "report tab is broken|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "008c0048-004b-0036-00da-002b00d500ff.png",
        "timestamp": 1534742957704,
        "duration": 182
    },
    {
        "description": "settings tab goes to reports|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "663f22d378573bfebf784db8875e05a2",
        "instanceId": 9052,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00c60092-00fc-0009-0043-00c900da0001.png",
        "timestamp": 1534742958183,
        "duration": 355
    }
];

    this.sortSpecs = function () {
        this.results = results.sort(function sortFunction(a, b) {
    if (a.sessionId < b.sessionId) return -1;else if (a.sessionId > b.sessionId) return 1;

    if (a.timestamp < b.timestamp) return -1;else if (a.timestamp > b.timestamp) return 1;

    return 0;
});
    };

    this.sortSpecs();
});

app.filter('bySearchSettings', function () {
    return function (items, searchSettings) {
        var filtered = [];
        var prevItem = null;

        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            item.displaySpecName = false;

            countLogMessages(item);

            var hasLog = searchSettings.withLog && item.browserLogs && item.browserLogs.length > 0;
            if (searchSettings.description === '' ||
                (item.description && item.description.toLowerCase().indexOf(searchSettings.description.toLowerCase()) > -1)) {

                if (searchSettings.passed && item.passed || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    var prevItem = item;
                } else if (searchSettings.failed && !item.passed && !item.pending || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    var prevItem = item;
                } else if (searchSettings.pending && item.pending || hasLog) {
                    checkIfShouldDisplaySpecName(prevItem, item);
                    filtered.push(item);
                    var prevItem = item;
                }

            }
        }

        return filtered;
    };
});

var checkIfShouldDisplaySpecName = function (prevItem, item) {
    if (!prevItem) {
        item.displaySpecName = true;
        return;
    }

    if (getSpec(item.description) != getSpec(prevItem.description)) {
        item.displaySpecName = true;
        return;
    }
};

var getSpec = function (str) {
    var describes = str.split('|');
    return describes[describes.length-1];
};

var countLogMessages = function (item) {
    if ((!item.logWarnings || !item.logErrors) && item.browserLogs && item.browserLogs.length > 0) {
        item.logWarnings = 0;
        item.logErrors = 0;
        for (var logNumber = 0; logNumber < item.browserLogs.length; logNumber++) {
            var logEntry = item.browserLogs[logNumber];
            if (logEntry.level === 'SEVERE') {
                item.logErrors++;
            }
            if (logEntry.level === 'WARNING') {
                item.logWarnings++;
            }
        }
    }
};