const express = require('express');
const app = express();
//console.log(__dirname);
const link = __dirname.substring(0, __dirname.indexOf('server')) + 'dist';
console.log(link);
app.use(express.static(link));
app.listen(3000, ()=>console.log('Server running on port 3000'))
