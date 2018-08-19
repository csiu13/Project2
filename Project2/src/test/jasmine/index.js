describe("login tests", function(){
	it("has login widget (auth0)", function(){
		var element=document.getElementsByClassName("auth0-lock-widget-container").item(0);
		expect(elemnt).toBe("auth0-lock-widget-container");
	});
	it("my second hello world test - failing test", function(){
		expect(true).toBe(false);
	});
});
