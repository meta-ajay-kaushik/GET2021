const express=require('express');
const path=require('path');
const app=express();
const port=3000;
staticPath = path.join(__dirname,'/code');
app.use(express.static(staticPath));
app.listen(port,()=>{console.log(`listening on port ${port}`)});