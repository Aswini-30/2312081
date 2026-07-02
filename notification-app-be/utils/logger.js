import fs from "fs";
export const logger=(type,message)=>{
    const date=new Date().toLocaleString();
    const mes=`[${date}] [${type}] ${message}\n`;
   // fs.appendFileSync("./logs/app.log",mes);
}