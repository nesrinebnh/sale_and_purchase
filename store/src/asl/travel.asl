// Agent travel in project store

/* Initial beliefs and rules */

/* Initial goals */


!start.

+!start <- .print("loaded!").

/* Plans */

+!find(From, To, Class, Price)  
  <- if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Doha(QTR)") 	& (Class == "All" | Class == "First_Class") & Price >= 2029)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways ALG-QTR First_Class"));}
     if((From == "All" | From == "Doha(QTR)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "First_Class") & Price >= 2504)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways QTR-ALG First_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Doha(QTR)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1791)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways ALG-QTR Business_Class"));}
     if((From == "All" | From == "Doha(QTR)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Business_Class") & Price >= 2209)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways QTR-ALG Business_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Doha(QTR)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1194)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways ALG-QTR Economy_Class"));}
     if((From == "All" | From == "Doha(QTR)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1473)
     {.print("[!] It's a Qatar Airways");.send(central, achieve, product("Qatar Airways QTR-ALG Economy_Class"));}
     
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Singapore(SIN)") 	& (Class == "All" | Class == "First_Class") & Price >= 1904)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines ALG-SIN First_Class"));}
     if((From == "All" | From == "Singapore(SIN)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "First_Class") & Price >= 2385)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines SIN-ALG First_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Singapore(SIN)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1680)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines ALG-SIN Business_Class"));}
     if((From == "All" | From == "Singapore(SIN)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Business_Class") & Price >= 2104)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines SIN-ALG Business_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Singapore(SIN)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1120)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines ALG-SIN Economy_Class"));}
     if((From == "All" | From == "Singapore(SIN)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1403)
     {.print("[!] It's a Singapore Airlines");.send(central, achieve, product("Singapore Airlines SIN-ALG Economy_Class"));}
     
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Dubai(UAE)") 	& (Class == "All" | Class == "First_Class") & Price >= 1341)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates ALG-UAE First_Class"));}
     if((From == "All" | From == "Dubai(UAE)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "First_Class") & Price >= 1725)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates UAE-ALG First_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Dubai(UAE)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1183)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates ALG-UAE Business_Class"));}
     if((From == "All" | From == "Dubai(UAE)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1522)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates UAE-ALG Business_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Dubai(UAE)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 789)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates ALG-UAE Economy_Class"));}
     if((From == "All" | From == "Dubai(UAE)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1015)
     {.print("[!] It's a Emirates");.send(central, achieve, product("Emirates UAE-ALG Economy_Class"));}
     
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Londo(UK)") 	& (Class == "All" | Class == "First_Class") & Price >= 797)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways ALG-UK First_Class"));}
     if((From == "All" | From == "Londo(UK)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "First_Class") & Price >= 1190)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways UK-ALG First_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Londo(UK)") 	& (Class == "All" | Class == "Business_Class") & Price >= 703)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways ALG-UK Business_Class"));}
     if((From == "All" | From == "Londo(UK)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1050)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways UK-ALG Business_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "Londo(UK)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 469)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways ALG-UK Economy_Class"));}
     if((From == "All" | From == "Londo(UK)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 700)
     {.print("[!] It's a British Airways");.send(central, achieve, product("British Airways UK-ALG Economy_Class"));}
     
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "New York(USA)") 	& (Class == "All" | Class == "First_Class") & Price >= 1426)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines ALG-USA First_Class"));}
     if((From == "All" | From == "New York(USA)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "First_Class") & Price >= 1955)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines USA-ALG First_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "New York(USA)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1258)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines ALG-USA Business_Class"));}
     if((From == "All" | From == "New York(USA)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Business_Class") & Price >= 1725)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines USA-ALG Business_Class"));}
     if((From == "All" | From == "Algiers(ALG)") 	& (To == "All" | To == "New York(USA)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 839)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines ALG-USA Economy_Class"));}
     if((From == "All" | From == "New York(USA)") 		& (To == "All" | To == "Algiers(ALG)") 	& (Class == "All" | Class == "Economy_Class") & Price >= 1150)
     {.print("[!] It's a American Airlines");.send(central, achieve, product("American Airlines USA-ALG Economy_Class"));}.
