describe('does the app exist?', function() {
  browser.get('https://assignforce-client.cfapps.io/login');
  it('should have a title', function() {
    browser.sleep(5000);
    expect(browser.getTitle()).toEqual('Assignforce');
  });

  it('should have a login widget', function(){
    var elm = element(by.id("auth0-lock-widget-container"));
    expect(browser.isElementPresent(elm)
    )
  });
});


describe('Can we log in and out?', function(){
  browser.get('https://assignforce-client.cfapps.io/login');
  browser.sleep(5000);
  browser.ignoreSynchronization = true;
  var username = element(by.name('email'))
  var password = element(by.name('password'))
  var submit = element(by.name('submit'));
  

  function login(user, pass){
    username.sendKeys(user);
    password.sendKeys(pass);
    submit.click();
    browser.sleep(5000);
  }

  function logout(){
    element(by.id("logoutBTN")).click();
  }

  it('it should be able to login (trainer)', function(){
    var user = 'test.trainer@revature.com';
    var pass = 'p@$$w0rd'; 
    login(user, pass);
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/overview');
  });

  it('it should be able to logout (trainer)', function(){
    browser.sleep(3000);
    logout();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/login');
  })

  it('it should be able to login (svp)', function(){
    browser.sleep(3000);
    var user = 'svp@revature.com';
    var pass = 'p@$$w0rd';
    login(user, pass);
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/overview');
  });

  it('it should be able to logout (svp)', function(){
    browser.sleep(3000);
    logout();
    browser.sleep(2000);
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/login');
  });
});

describe('testing tabs', function(){
  var username = element(by.name('email'))
  var password = element(by.name('password'))
  var submit = element(by.name('submit'));
  function login(user, pass){
    username.sendKeys(user);
    password.sendKeys(pass);
    submit.click();
    browser.sleep(5000);
  }

  function logout(){
    element(by.id("logoutBTN")).click();
  }

  it('overview should be on the overview page', function(){
    var user = 'svp@revature.com';
    var pass = 'p@$$w0rd';
    login(user, pass);
    element(by.id('mat-tab-label-0-0')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/overview');
  });

  it('batches should be on the batches page', function(){
    element(by.id('mat-tab-label-0-1')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/batches');
  });
  it('locations should be on the locations page', function(){
    element(by.id('mat-tab-label-0-2')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/locations');
  });
  it('curricula should be on the curricula page', function(){
    element(by.id('mat-tab-label-0-3')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/curricula');
  });
  it('trainers should be on the trainers page', function(){
    element(by.id('mat-tab-label-0-4')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/trainers');
  });
  it('reports should be on the reports page', function(){
    element(by.id('mat-tab-label-0-5')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/reports');
  });
  it('settings should be on the settings page', function(){
    element(by.id('mat-tab-label-0-6')).click();
    expect(browser.getCurrentUrl()).toEqual('https://assignforce-client.cfapps.io/settings');
  });
});

// describe('Testing collapsable things', function(){
//   browser.get('https://assignforce-client.cfapps.io/login');
//   browser.sleep(2000);
//   browser.ignoreSynchronization = true;
//   var username = element(by.name('email'))
//   var password = element(by.name('password'))
//   var submit = element(by.name('submit'));
//   function login(user, pass){
//     username.sendKeys(user);
//     password.sendKeys(pass);
//     submit.click();
//     return true;
//   }

//   function logout(){
//     element(by.id("logoutBTN")).click();
//   }
//   var user = 'svp@revature.com';
//   var pass = 'p@$$w0rd';
//   browser.wait(function(){
//     username.sendKeys(user);
//     password.sendKeys(pass);
//     submit.click();
//     return true;
//   }, 3000);
  // the above is for testing

//   describe('Batch Tab', function(){
//     // browser.wait(function(){
//     //   if(browser.getCurrentUrl() == 'https://assignforce-client.cfapps.io/overview');
//     //   return true;
//     // }, 3000).then(function(){
//     //   element(by.id('mat-tab-label-0-1')).click();
//     // }, 3000);
//     var EC = protractor.ExpectedConditions;
//     var e = element(by.id('mat-tab-label-0-1'));
//     browser.wait(EC.presenceOf(e), 5000);
//     e.click();
    
//     it('Can I collapse Create a Batch?', function(){
//       var e1 = element(by.id('mat-expansion-panel-header-3'));
//       browser.wait(EC.presenceOf(e1), 5000);
//       e1.click()
//       // var e2 = element(by.id('mat-expansion-panel-header-3'))
//       // browser.wait(EC.presenceOf(e2), 5000);
//       console.log(e1.offsetHeight);
//       // var height = element(by.id('mat-expansion-panel-header-3')).style.height;
//       // console.log(height);
//       // expect(element(by.id('mat-expansion-panel-header-2')).style.height == 48);
//       expect(1 == 1);
//     })
//   });

// });
