// Agent cars in project store

/* Initial beliefs and rules */

/* Initial goals */


!start.

+!start <- .print("loaded!").

/* Plans */

+!find(Manufacturer, Trans, Fuel, Style, Size, Hp, Price)
	<- 	if ((Manufacturer == "All" | Manufacturer == "Lamborghini") 	& (Trans == "All" | Trans == "a") 			& (Fuel == "All" | Fuel == "prem")   	& Hp <= 450 & (Style == "All" | Style == "Coupe") 				& (Size == "All" | Size == "sm") & Price >=  199800) 
		{.print("[!] It's a Huracan"); .send(central, achieve, product("Lamborghini Huracan")); }
		if ((Manufacturer == "All" | Manufacturer == "Ferrari" 	) 		& (Trans == "All" | Trans == "a") 			& (Fuel == "All" | Fuel == "prem")   	& Hp <= 450 & (Style == "All" | Style == "Coupe") 				& (Size == "All" | Size == "sm") & Price >=  291744) 
		{.print("[!] It's a 458_Italia"); .send(central, achieve, product("Ferrari 458_Italia")); }
		if ((Manufacturer == "All" | Manufacturer == "Ferrari"	) 		& (Trans == "All" | Trans == "a") 			& (Fuel == "All" | Fuel == "prem")   	& Hp <= 450 & (Style == "All" | Style == "Convertible") 		& (Size == "All" | Size == "sm") & Price >=  180408) 
		{.print("[!] It's a 360"); .send(central, achieve, product("Ferrari 360")); }
		if ((Manufacturer == "All" | Manufacturer == "Ferrari"	) 		& (Trans == "All" | Trans == "a") 			& (Fuel == "All" | Fuel == "prem")   	& Hp <= 450 & (Style == "All" | Style == "Coupe") 				& (Size == "All" | Size == "md") & Price >=  410000) 
		{.print("[!] It's a 599"); .send(central, achieve, product("Ferrari 599")); }
		if ((Manufacturer == "All" | Manufacturer == "FIAT"	   	) 		& (Trans == "All" | Trans == "m") 			& (Fuel == "All" | Fuel == "prem")   	& Hp <= 450 & (Style == "All" | Style == "Convertible") 		& (Size == "All" | Size == "sm") & Price >=  208195) 
		{.print("[!] It's a 124_Spider"); .send(central, achieve, product("FIAT 124_Spider")); }	
		if ((Manufacturer == "All" | Manufacturer == "FIAT"	   ) 		& (Trans == "All" | Trans == "DIRECT_DRIVE") & (Fuel == "All" | Fuel == "elec")   	& Hp <= 350 & (Style == "All" | Style == "2dr_Hatchback") 		& (Size == "All" | Size == "sm") & Price >=  31800) 
		{.print("[!] It's a 500e"); .send(central, achieve, product("FIAT 500")); }
		if ((Manufacturer == "All" | Manufacturer == "Chevrolet" ) 		& (Trans == "All" | Trans == "DIRECT_DRIVE") & (Fuel == "All" | Fuel == "elec")   	& Hp <= 350 & (Style == "All" | Style == "4dr_Hatchback") 		& (Size == "All" | Size == "sm") & Price >=  36620) 
		{.print("[!] It's a Bolt_EV"); .send(central, achieve, product("Chevrolet Bolt_EV")); }
		if ((Manufacturer == "All" | Manufacturer == "Volkswagen") 		& (Trans == "All" | Trans == "DIRECT_DRIVE") & (Fuel == "All" | Fuel == "elec")   	& Hp <= 350 & (Style == "All" | Style == "4dr_Hatchback") 		& (Size == "All" | Size == "sm") & Price >=  35595) 
		{.print("[!] It's a e-Golf"); .send(central, achieve, product("Volkswagen e-Golf")); }
		if ((Manufacturer == "All" | Manufacturer == "Tesla"	   ) 	& (Trans == "All" | Trans == "DIRECT_DRIVE") & (Fuel == "All" | Fuel == "elec")   	& Hp <= 350 & (Style == "All" | Style == "Sedan")		 		& (Size == "All" | Size == "md") & Price >= 112000) 
		{.print("[!] It's a Model_S"); .send(central, achieve, product("Tesla Model S")); }
		if ((Manufacturer == "All" | Manufacturer == "Volkswagen"	) 	& (Trans == "All" | Trans == "m") 			 & (Fuel == "All" | Fuel == "reg")   	& Hp <= 210 & (Style == "All" | Style == "2dr_Hatchback") 		& (Size == "All" | Size == "sm") & Price >= 24785) 
		{.print("[!] It's a golf"); .send(central, achieve, product("Volkswagen Golf")); }
		if ((Manufacturer == "All" | Manufacturer == "Chrysler"	) 	  	& (Trans == "All" | Trans == "a") 			 & (Fuel == "All" | Fuel == "reg")   	& Hp <= 184 & (Style == "All" | Style == "Sedan") 		  		& (Size == "All" | Size == "md") & Price >= 27795) 
		{.print("[!] It's a 200"); .send(central, achieve, product("Chrysler 200")); }
		if ((Manufacturer == "All" | Manufacturer == "Nissan"		) 	& (Trans == "All" | Trans == "a")  			 & (Fuel == "All" | Fuel == "reg")   	& Hp <= 200 & (Style == "All" | Style == "Convertible")   		& (Size == "All" | Size == "sm") & Price >= 39630) 
		{.print("[!] It's a Versa"); .send(central, achieve, product("Nissan Versa")); }
		if ((Manufacturer == "All" | Manufacturer == "Rolls-Royce")   	& (Trans == "All" | Trans == "a")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 453 & (Style == "All" | Style == "Sedan") 				& (Size == "All" | Size == "lg") & Price >= 492425) 
		{.print("[!] It's a Phantom"); .send(central, achieve, product("Rolls-Royce Phantom")); }
		if ((Manufacturer == "All" | Manufacturer == "BMW"		)     	& (Trans == "All" | Trans == "m")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 320 & (Style == "All" | Style == "Sedan") 				& (Size == "All" | Size == "md") & Price >=  49900) 
		{.print("[!] It's a 3_Series"); .send(central, achieve, product("BMW 3_Series")); }
		if ((Manufacturer == "All" | Manufacturer == "Alfa_Romeo" )   	& (Trans == "All" | Trans == "a")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 337 & (Style == "All" | Style == "Coupe") 				& (Size == "All" | Size == "sm") & Price >=  65900) 
		{.print("[!] It's a 4c"); .send(central, achieve, product("Alfa_Romeo 4c")); }
		if ((Manufacturer == "All" | Manufacturer == "Audi"		) 	  	& (Trans == "All" | Trans == "m")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 320 & (Style == "All" | Style == "Sedan") 				& (Size == "All" | Size == "md") & Price >=  34200) 
		{.print("[!] It's a a3"); .send(central, achieve, product("Audi a3")); }
		if ((Manufacturer == "All" | Manufacturer == "HUMMER"		) 	& (Trans == "All" | Trans == "a")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 320 & (Style == "All" | Style == "SUV"  ) 				& (Size == "All" | Size == "lg") & Price >=  35680) 
		{.print("[!] It's a H3T"); .send(central, achieve, product("HUMMERH3T")); }
		if ((Manufacturer == "All" | Manufacturer == "Porche"		) 	& (Trans == "All" | Trans == "a")			 & (Fuel == "All" | Fuel == "prem")   	& Hp <= 400 & (Style == "All" | Style == "SUV"  ) 				& (Size == "All" | Size == "md") & Price >=  76000) 
		{.print("[!] It's a Macan"); .send(central, achieve, product("Porche Macan")); }.
  	 