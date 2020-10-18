// Agent phones in project store

/* Initial beliefs and rules */

/* Initial goals */


!start.

+!start <- .print("loaded!").

/* Plans */

+!find(Manufacturer, CPU, RAM, ROM, Battery, Screen, Fingerprint, Size, Price)
  <-if((Manufacturer == "All" | Manufacturer == "Samsung") 	& (CPU == "All" | CPU == "Snapdragon_865") 	& RAM<=16 	& ROM<=512 	& Battery<=5000 & (Screen == "All" | Screen == "Dynamic_AMOLED") 	& (Fingerprint == "All" | Fingerprint == "Under_display") 	& Size<=6.9 	& Price >= 1400)
  	{.print("Galaxy_S20"); .send(central, achieve, product("Samsung Galaxy_S20"));}
	if((Manufacturer == "All" | Manufacturer == "Samsung") 	& (CPU == "All" | CPU == "Snapdragon_835") 	& RAM<=4 	& ROM<=64 	& Battery<=3000 & (Screen == "All" | Screen == "Super_AMOLED") 		& (Fingerprint == "All" | Fingerprint == "Rear_mounted") 	& Size<=5.8 	& Price >= 500)
	{.print("Galaxy_S8"); .send(central, achieve, product("Samsung Galaxy_S8"));}
    if((Manufacturer == "All" | Manufacturer == "Samsung") 	& (CPU == "All" | CPU == "Snapdragon_855") 	& RAM<=12 	& ROM<=512 	& Battery<=4380 & (Screen == "All" | Screen == "Dynamic_AMOLED") 	& (Fingerprint == "All" | Fingerprint == "Side-mounted") 	& Size<=7.3 	& Price >= 1400)
    {.print("Galaxy_FOLD"); .send(central, achieve, product("Samsung Galaxy_FOLD"));}
	if((Manufacturer == "All" | Manufacturer == "Apple") 	& (CPU == "All" | CPU == "A13_Bionic") 		& RAM<=4 	& ROM<=512 	& Battery<=3969 & (Screen == "All" | Screen == "Super_Retina") 		& (Fingerprint == "All" | Fingerprint == "NONE") 			& Size<=6.5 	& Price >= 1450)
	{.print("IPhone_11_Pro_MAx"); .send(central, achieve, product("Apple IPhone_11_Pro_MAx"));}
    if((Manufacturer == "All" | Manufacturer == "Apple") 	& (CPU == "All" | CPU == "A13_Bionic") 		& RAM<=6 	& ROM<=512 	& Battery<=9720 & (Screen == "All" | Screen == "LCD") 				& (Fingerprint == "All" | Fingerprint == "NONE") 			& Size>=12.9 	& Price >= 1000)
    {.print("IPad_Pro"); .send(central, achieve, product("Apple IPad_Pro"));}
	if((Manufacturer == "All" | Manufacturer == "Apple") 	& (CPU == "All" | CPU == "A13_Bionic") 		& RAM<=3 	& ROM<=256 	& Battery<=2691 & (Screen == "All" | Screen == "Retina_LCD") 		& (Fingerprint == "All" | Fingerprint == "Front_mounted") 	& Size<=5.5 	& Price >= 450)
	{.print("Iphone_8_Plus"); .send(central, achieve, product("Apple Iphone_8_Plus"));}
    if((Manufacturer == "All" | Manufacturer == "LG") 		& (CPU == "All" | CPU == "Snapdragon_855") 	& RAM<=6 	& ROM<=128 	& Battery<=3500 & (Screen == "All" | Screen == "P-OLED") 			& (Fingerprint == "All" | Fingerprint == "Rear_mounted") 	& Size<=6.1 	& Price >= 800)
    {.print("G8_ThinQ"); .send(central, achieve, product("LG G8_ThinQ"));}
	if((Manufacturer == "All" | Manufacturer == "LG") 		& (CPU == "All" | CPU == "Snapdragon_865") 	& RAM<=8 	& ROM<=128 	& Battery<=5000 & (Screen == "All" | Screen == "P-OLED") 			& (Fingerprint == "All" | Fingerprint == "Under_display") 	& Size<=6.8 	& Price >= 700)
	{.print("V60_ThinQ"); .send(central, achieve, product("LG V60_ThinQ"));}
    if((Manufacturer == "All" | Manufacturer == "Google") 	& (CPU == "All" | CPU == "Snapdragon_855") 	& RAM<=6 	& ROM<=128 	& Battery<=3700 & (Screen == "All" | Screen == "P-OLED") 			& (Fingerprint == "All" | Fingerprint == "NONE") 			& Size<=6.3 	& Price >= 800)
    {.print("Pixel_4XL"); .send(central, achieve, product("Google Pixel_4XL"));}
	if((Manufacturer == "All" | Manufacturer == "Google") 	& (CPU == "All" | CPU == "Snapdragon_845") 	& RAM<=4 	& ROM<=128 	& Battery<=2915 & (Screen == "All" | Screen == "P-OLED") 			& (Fingerprint == "All" | Fingerprint == "Rear_mounted") 	& Size<=5.5 	& Price >= 700)
	{.print("Pixel_3"); .send(central, achieve, product("Google Pixel_3"));}
    if((Manufacturer == "All" | Manufacturer == "OnePlus") 	& (CPU == "All" | CPU == "Snapdragon_845") 	& RAM<=8 	& ROM<=256 	& Battery<=3700 & (Screen == "All" | Screen == "Optic_AMOLED") 		& (Fingerprint == "All" | Fingerprint == "Under_display") 	& Size<=6.41 	& Price >= 500)
    {.print("6T"); .send(central, achieve, product("OnePlus 6T"));}
	if((Manufacturer == "All" | Manufacturer == "OnePlus") 	& (CPU == "All" | CPU == "Snapdragon_855") 	& RAM<=8 	& ROM<=256 	& Battery<=3800 & (Screen == "All" | Screen == "Fluid_AMOLED") 		& (Fingerprint == "All" | Fingerprint == "Under_display") 	& Size<=6.55 	& Price >= 600)
	{.print("7T"); .send(central, achieve, product("OnePlus 7T"));}
    if((Manufacturer == "All" | Manufacturer == "Asus") 	& (CPU == "All" | CPU == "Snapdragon_845") 	& RAM<=8 	& ROM<=512 	& Battery<=4000 & (Screen == "All" | Screen == "AMOLED") 			& (Fingerprint == "All" | Fingerprint == "Rear_mounted") 	& Size<=6.0 	& Price >= 700)
    {.print("ROG_Phone"); .send(central, achieve, product("Asus ROG_Phone"));}
	if((Manufacturer == "All" | Manufacturer == "Asus") 	& (CPU == "All" | CPU == "Snapdragon_855") 	& RAM<=12 	& ROM<=512 	& Battery<=6000 & (Screen == "All" | Screen == "AMOLED") 			& (Fingerprint == "All" | Fingerprint == "Under_display") 	& Size<=6.59 	& Price >= 1300)
	{.print("ROG_Phone_II"); .send(central, achieve, product("Asus ROG_Phone_II"));}
    if((Manufacturer == "All" | Manufacturer == "Xiaomi") 	& (CPU == "All" | CPU == "Snapdragon_720G") & RAM<=6 	& ROM<=128 	& Battery<=5020 & (Screen == "All" | Screen == "LCD") 				& (Fingerprint == "All" | Fingerprint == "Side-mounted") 	& Size<=6.67 	& Price >= 270)
    {.print("Redmi_Note_9_Pro"); .send(central, achieve, product("Xiaomi Redmi_Note_9_Pro"));}
	if((Manufacturer == "All" | Manufacturer == "Xiaomi") 	& (CPU == "All" | CPU == "Snapdragon_865") 	& RAM<=12 	& ROM<=512 	& Battery<=4500 & (Screen == "All" | Screen == "Super_AMOLED") 		& (Fingerprint == "All" | Fingerprint == "Side-mounted") 	& Size<=6.67 	& Price >= 790)
	{.print("Mi_10_pro"); .send(central, achieve, product("Xiaomi Mi_10_pro"));}.
