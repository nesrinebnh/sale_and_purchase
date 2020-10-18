// Agent buses in project store

/* Initial beliefs and rules */

/* Initial goals */


!start.

+!start <- .print("loaded!").

/* Plans */

+!find(Manufacturer, Bus_Type, Size, Price)
  <-if ((Manufacturer == "All" | Manufacturer == "MCV") 		& (Bus_Type == "All" | Bus_Type == "double_deck") & (Size == "All" | Size == "lg") & Price >= 134142) 
  	{.print("[!] It's a 800");.send(central, achieve, product("MCV 800 double_deck"));}
	if ((Manufacturer == "All" | Manufacturer == "Volvo") 		& (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "md") & Price >=  21612) 
	{.print("[!] It's a 7900");.send(central, achieve, product("Volvo 7900 single_deck"));}
	if ((Manufacturer == "All" | Manufacturer == "TransBus") 	& (Bus_Type == "All" | Bus_Type == "double_deck") & (Size == "All" | Size == "md") & Price >=  20000) 
	{.print("[!] It's a ALX400");.send(central, achieve, product("TransBus ALX400 double_deck"));}
	if ((Manufacturer == "All" | Manufacturer == "VDL_Berkhof") & (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "sm") & Price >=  16379) 
	{.print("[!] It's a Ambassador");.send(central, achieve, product("VDL_Berkhof Ambassador single_deck"));}
	if ((Manufacturer == "All" | Manufacturer == "Goppel") 		& (Bus_Type == "All" | Bus_Type == "single_deck") & (Size == "All" | Size == "lg") & Price >= 120000) 
	{.print("[!] It's a AutoTram_Extra_Grand");.send(central, achieve, product("Goppel AutoTram_Extra_Grand single_deck"));}.
			