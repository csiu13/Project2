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
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00600013-000e-0064-002c-005c008e008b.png",
        "timestamp": 1534743461323,
        "duration": 13718
    },
    {
        "description": "should have a login widget|does the app exist?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed",
        "browserLogs": [],
        "screenShotFile": "005c003c-00d5-0028-009b-002300a20005.png",
        "timestamp": 1534743475806,
        "duration": 47
    },
    {
        "description": "it should be able to login (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743477381,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/72d2ed354468e51d557d8dd7a3111f66.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534743477518,
                "type": ""
            }
        ],
        "screenShotFile": "00f90050-0032-005c-004a-009e002b0010.png",
        "timestamp": 1534743476318,
        "duration": 6320
    },
    {
        "description": "it should be able to logout (trainer)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743486141,
                "type": ""
            }
        ],
        "screenShotFile": "00c500f1-008c-00c5-002e-00c7002000e2.png",
        "timestamp": 1534743483012,
        "duration": 3907
    },
    {
        "description": "it should be able to login (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743496133,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534743496133,
                "type": ""
            }
        ],
        "screenShotFile": "00ce004b-00db-008a-0035-0075006c00b9.png",
        "timestamp": 1534743487532,
        "duration": 8616
    },
    {
        "description": "it should be able to logout (svp)|Can we log in and out?",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743499696,
                "type": ""
            }
        ],
        "screenShotFile": "003000c8-00b3-006c-000a-002c000000f5.png",
        "timestamp": 1534743496462,
        "duration": 5603
    },
    {
        "description": "overview should be on the overview page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743503597,
                "type": ""
            },
            {
                "level": "SEVERE",
                "message": "https://secure.gravatar.com/7e20ee4b93ca68a3a2d4f0fd787fba95.json?callback=__jp0 - Failed to load resource: the server responded with a status of 404 ()",
                "timestamp": 1534743508656,
                "type": ""
            }
        ],
        "screenShotFile": "003e0058-00d4-00dd-0000-006b00de00f3.png",
        "timestamp": 1534743502784,
        "duration": 5965
    },
    {
        "description": "batches should be on the batches page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
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
                "timestamp": 1534743509354,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509359,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509362,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509363,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509364,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509364,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509365,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509526,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509532,
                "type": ""
            },
            {
                "level": "WARNING",
                "message": "https://assignforce-client.cfapps.io/main.a3dbef466351ca54e462.bundle.js 0:1520783 \"\\n      It looks like you're using the disabled attribute with a reactive form directive. If you set disabled to true\\n      when you set up this control in your component class, the disabled attribute will actually be set in the DOM for\\n      you. We recommend using this approach to avoid 'changed after checked' errors.\\n       \\n      Example: \\n      form = new FormGroup({\\n        first: new FormControl({value: 'Nancy', disabled: true}, Validators.required),\\n        last: new FormControl('Drew', Validators.required)\\n      });\\n    \"",
                "timestamp": 1534743509533,
                "type": ""
            }
        ],
        "screenShotFile": "003f00b8-0033-002e-00b8-0015007300ad.png",
        "timestamp": 1534743509115,
        "duration": 4253
    },
    {
        "description": "locations should be on the locations page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "008900c3-00e8-00ee-00bb-002b00200032.png",
        "timestamp": 1534743513719,
        "duration": 618
    },
    {
        "description": "curricula should be on the curricula page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "007e009a-0014-002a-00e1-00840054001c.png",
        "timestamp": 1534743514697,
        "duration": 164
    },
    {
        "description": "trainers should be on the trainers page|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "004300fd-00fb-0032-0047-001100fc00a6.png",
        "timestamp": 1534743515347,
        "duration": 137
    },
    {
        "description": "report tab is broken|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "005700a3-0071-0026-000c-00ce00020007.png",
        "timestamp": 1534743515948,
        "duration": 250
    },
    {
        "description": "settings tab goes to reports|testing tabs",
        "passed": true,
        "pending": false,
        "os": "Windows NT",
        "sessionId": "0000e36d8246655e91f8a6e34edf06de",
        "instanceId": 38644,
        "browser": {
            "name": "chrome",
            "version": "68.0.3440.106"
        },
        "message": "Passed.",
        "trace": "",
        "browserLogs": [],
        "screenShotFile": "00e900dc-005e-004d-0077-000000170008.png",
        "timestamp": 1534743516538,
        "duration": 615
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