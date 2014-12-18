package mods.timaxa007.pack.mining.lib;

public class PeriodicTable {

	public String getXX[] = new String[] {
			"", 		//	0	None
			"H", 	//	1	Hydrogen
			"He", 	//	2	Helium
			"Li", 	//	3	Lithium
			"Be", 	//	4	Beryllium
			"B", 	//	5	Boron
			"C", 	//	6	Carbon
			"N", 	//	7	Nitrogen
			"O", 	//	8	Oxygen
			"F", 	//	9	Fluorine
			"Ne", 	//	10	Neon
			"Na", 	//	11	Sodium
			"Mg", 	//	12	Magnesium
			"Al", 	//	13	Aluminium
			"Si", 	//	14	Silicon
			"P", 	//	15	Phosphorus
			"S", 	//	16	Sulfur
			"Cl", 	//	17	Chlorine
			"Ar", 	//	18	Argon
			"K", 	//	19	Potassium
			"Ca", 	//	20	Calcium
			"Sc", 	//	21	Scandium
			"Ti", 	//	22	Titanium
			"V", 	//	23	Vanadium
			"Cr", 	//	24	Chromium
			"Mn", 	//	25	Manganese
			"Fe", 	//	26	Iron
			"Co", 	//	27	Cobalt
			"Ni", 	//	28	Nickel
			"Cu", 	//	29	Copper
			"Zn", 	//	30	Zinc
			"Ga", 	//	31	Gallium
			"Ge", 	//	32	Germanium
			"As", 	//	33	Arsenic
			"Se", 	//	34	Selenium
			"Br", 	//	35	Bromine
			"Kr", 	//	36	Krypton
			"Rb", 	//	37	Rubidium
			"Sr", 	//	38	Strontium
			"Y", 	//	39	Yttrium
			"Zr", 	//	40	Zirconium
			"Nb", 	//	41	Niobium
			"Mo", 	//	42	Molybdenum
			"Tc", 	//	43	Technetium
			"Ru", 	//	44	Ruthenium
			"Rh", 	//	45	Rhodium
			"Pd", 	//	46	Palladium
			"Ag", 	//	47	Silver
			"Cd", 	//	48	Cadmium
			"In", 	//	49	Indium
			"Sn", 	//	50	Tin
			"Sb", 	//	51	Antimony
			"Tc", 	//	52	Tellurium
			"I", 	//	53	Iodine
			"Xe", 	//	54	Xenon
			"Cs", 	//	55	Caesium
			"Ba", 	//	56	Barium
			"La", 	//	57	Lanthanum
			"Ce", 	//	58	Cerium
			"Pr", 	//	59	Praseodymium
			"Nd", 	//	60	Neodymium
			"Pm", 	//	61	Promethium
			"Sm", 	//	62	Samarium
			"Eu", 	//	63	Europium
			"Gd", 	//	64	Gadolinium
			"Tb", 	//	65	Terbium
			"Dy", 	//	66	Dysprosium
			"Ho", 	//	67	Holmium
			"Er", 	//	68	Erbium
			"Tm", 	//	69	Thulium
			"Yb", 	//	70	Ytterbium
			"Lu", 	//	71	Lutetium
			"Hf", 	//	72	Hafnium
			"Ta", 	//	73	Tantalum
			"Tg", 	//	74	Tungsten
			"Re", 	//	75	Rhenium
			"Os", 	//	76	Osmium
			"Ir", 	//	77	Iridium
			"Pt", 	//	78	Platinum
			"Au", 	//	79	Gold
			"Hg", 	//	80	Mercury
			"Ti", 	//	81	Thallium
			"Pd", 	//	82	Lead
			"Bi", 	//	83	Bismuth
			"Po", 	//	84	Polonium
			"Al", 	//	85	Astatine
			"Rn", 	//	86	Radon
			"Fr", 	//	87	Francium
			"Ra", 	//	88	Radium
			"Ac", 	//	89	Actinium
			"Th", 	//	90	Thorium
			"Pa", 	//	91	Protactinium
			"U", 	//	92	Uranium
			"Np", 	//	93	Neptunium
			"Pu", 	//	94	Plutonium
			"Am", 	//	95	Americium
			"Cm", 	//	96	Curium
			"Bk", 	//	97	Berkelium
			"Cf", 	//	98	Californium
			"Es", 	//	99	Einsteinium
			"Fm", 	//	100	Fermium
			"Md", 	//	101	Mendelevium
			"No", 	//	102	Nobelium
			"Lr", 	//	103	Lawrencium
			"Rf", 	//	104	Rutherfordium
			"Db", 	//	105	Dubnium
			"Sg", 	//	106	Seaborgium
			"Bh", 	//	107	Bohrium
			"Hs", 	//	108	Hassium
			"Mt", 	//	109	Meitnerium
			"Ds", 	//	110	Darmstadtium
			"Rg", 	//	111	Roentgenium
			"Cn", 	//	112	Copernicium
			"Uut", 	//	113	Ununtrium
			"Fl", 	//	114	Flerovium
			"Uup", 	//	115	Ununpentium
			"Lv", 	//	116	Livermorium
			"Uus", 	//	117	Ununseptium
			"Uuo"	//	118	Ununoctium
	};

	public enum getEnumXX {
		None((short)0, "", 0xFFFFFF), 
		Hydrogen((short)1, "H", 0xFFFFFF), 
		Helium((short)2, "He", 0xFFFFFF), 
		Lithium((short)3, "Li", 0xFFFFFF), 
		Beryllium((short)4, "Be", 0xFFFFFF), 
		Boron((short)5, "B", 0xFFFFFF), 
		Carbon((short)6, "C", 0xFFFFFF), 
		Nitrogen((short)7, "N", 0xFFFFFF), 
		Oxygen((short)8, "O", 0xFFFFFF), 
		Fluorine((short)9, "F", 0xFFFFFF), 
		Neon((short)10, "Ne", 0xFFFFFF), 
		Sodium((short)11, "Na", 0xFFFFFF), 
		Magnesium((short)12, "Mg", 0xFFFFFF), 
		Aluminium((short)13, "Al", 0xFFFFFF), 
		Silicon((short)14, "Si", 0xFFFFFF), 
		Phosphorus((short)15, "P", 0xFFFFFF), 
		Sulfur((short)16, "S", 0xFFFFFF), 
		Chlorine((short)17, "Cl", 0xFFFFFF), 
		Argon((short)18, "Ar", 0xFFFFFF), 
		Potassium((short)19, "K", 0xFFFFFF), 
		Calcium((short)20, "Ca", 0xFFFFFF), 
		Scandium((short)21, "Sc", 0xFFFFFF), 
		Titanium((short)22, "Ti", 0xFFFFFF), 
		Vanadium((short)23, "V", 0xFFFFFF), 
		Chromium((short)24, "Cr", 0xFFFFFF), 
		Manganese((short)25, "Mn", 0xFFFFFF), 
		Iron((short)26, "Fe", 0xFFFFFF), 
		Cobalt((short)27, "Co", 0xFFFFFF), 
		Nickel((short)28, "Ni", 0xFFFFFF), 
		Copper((short)29, "Cu", 0xB87333), 
		Zinc((short)30, "Zn", 0xFFFFFF), 
		Gallium((short)31, "Ga", 0xFFFFFF), 
		Germanium((short)32, "Ge", 0xFFFFFF), 
		Arsenic((short)33, "As", 0xFFFFFF), 
		Selenium((short)34, "Se", 0xFFFFFF), 
		Bromine((short)35, "Br", 0xFFFFFF), 
		Krypton((short)36, "Kr", 0xFFFFFF), 
		Rubidium((short)37, "Rb", 0xFFFFFF), 
		Strontium((short)38, "Sr", 0xFFFFFF), 
		Yttrium((short)39, "Y", 0xFFFFFF), 
		Zirconium((short)40, "Zr", 0xFFFFFF), 
		Niobium((short)41, "Nb", 0xFFFFFF), 
		Molybdenum((short)42, "Mo", 0xFFFFFF), 
		Technetium((short)43, "Tc", 0xFFFFFF), 
		Ruthenium((short)44, "Ru", 0xFFFFFF), 
		Rhodium((short)46, "Rh", 0xFFFFFF), 
		Palladium((short)46, "Pd", 0xFFFFFF), 
		Silver((short)47, "Ag", 0xC0C0C0), 
		Cadmium((short)48, "Cd", 0xFFFFFF), 
		Indium((short)49, "In", 0xFFFFFF), 
		Tin((short)50, "Sn", 0xDDDDDD), 
		Antimony((short)51, "Sb", 0xFFFFFF), 
		Tellurium((short)52, "Tc", 0xFFFFFF), 
		Iodine((short)53, "I", 0xFFFFFF), 
		Xenon((short)54, "Xe", 0xFFFFFF), 
		Caesium((short)55, "Cs", 0xFFFFFF), 
		Barium((short)56, "Ba", 0xFFFFFF), 
		Lanthanum((short)57, "La", 0xFFFFFF), 
		Cerium((short)58, "Ce", 0xFFFFFF), 
		Praseodymium((short)59, "Pr", 0xFFFFFF), 
		Neodymium((short)60, "Nd", 0xFFFFFF), 
		Promethium((short)61, "Pm", 0xFFFFFF), 
		Samarium((short)62, "Sm", 0xFFFFFF), 
		Europium((short)63, "Eu", 0xFFFFFF), 
		Gadolinium((short)64, "Gd", 0xFFFFFF), 
		Terbium((short)65, "Tb", 0xFFFFFF), 
		Dysprosium((short)66, "Dy", 0xFFFFFF), 
		Holmium((short)67, "Ho", 0xFFFFFF), 
		Erbium((short)68, "Er", 0xFFFFFF), 
		Thulium((short)69, "Tm", 0xFFFFFF), 
		Ytterbium((short)70, "Yb", 0xFFFFFF), 
		Lutetium((short)71, "Lu", 0xFFFFFF), 
		Hafnium((short)72, "Hf", 0xFFFFFF), 
		Tantalum((short)73, "Ta", 0xFFFFFF), 
		Tungsten((short)74, "Tg", 0xFFFFFF), 
		Rhenium((short)75, "Re", 0xFFFFFF), 
		Osmium((short)76, "Os", 0xFFFFFF), 
		Iridium((short)77, "Ir", 0xFFFFFF), 
		Platinum((short)78, "Pt", 0xFFFFFF), 
		Gold((short)79, "Au", 0xFFD700), 
		Mercury((short)80, "Hg", 0xFFFFFF), 
		Thallium((short)81, "Ti", 0xFFFFFF), 
		Lead((short)82, "Pd", 0xFFFFFF), 
		Bismuth((short)83, "Bi", 0xFFFFFF), 
		Polonium((short)84, "Po", 0xFFFFFF), 
		Astatine((short)85, "Al", 0xFFFFFF), 
		Radon((short)86, "Rn", 0xFFFFFF), 
		Francium((short)87, "Fr", 0xFFFFFF), 
		Radium((short)88, "Ra", 0xFFFFFF), 
		Actinium((short)89, "Ac", 0xFFFFFF), 
		Thorium((short)90, "Th", 0xFFFFFF), 
		Protactinium((short)91, "Pa", 0xFFFFFF), 
		Uranium((short)92, "U", 0xFFFFFF), 
		Neptunium((short)93, "Np", 0xFFFFFF), 
		Plutonium((short)94, "Pu", 0xFFFFFF), 
		Americium((short)95, "Am", 0xFFFFFF), 
		Curium((short)96, "Cm", 0xFFFFFF), 
		Berkelium((short)97, "Bk", 0xFFFFFF), 
		Californium((short)98, "Cf", 0xFFFFFF), 
		Einsteinium((short)99, "Es", 0xFFFFFF), 
		Fermium((short)110, "Fm", 0xFFFFFF), 
		Mendelevium((short)101, "Md", 0xFFFFFF), 
		Nobelium((short)102, "No", 0xFFFFFF), 
		Lawrencium((short)103, "Lr", 0xFFFFFF), 
		Rutherfordium((short)104, "Rf", 0xFFFFFF), 
		Dubnium((short)105, "Db", 0xFFFFFF), 
		Seaborgium((short)106, "Sg", 0xFFFFFF), 
		Bohrium((short)107, "Bh", 0xFFFFFF), 
		Hassium((short)108, "Hs", 0xFFFFFF), 
		Meitnerium((short)109, "Mt", 0xFFFFFF), 
		Darmstadtium((short)110, "Ds", 0xFFFFFF), 
		Roentgenium((short)111, "Rg", 0xFFFFFF), 
		Copernicium((short)112, "Cn", 0xFFFFFF), 
		Ununtrium((short)113, "Uut", 0xFFFFFF), 
		Flerovium((short)114, "Fl", 0xFFFFFF), 
		Ununpentium((short)115, "Uup", 0xFFFFFF), 
		Livermorium((short)116, "Lv", 0xFFFFFF), 
		Ununseptium((short)117, "Uus", 0xFFFFFF), 
		Ununoctium((short)118, "Uuo", 0xFFFFFF);

		private short ids;
		private String name;
		private int colorHex;

		getEnumXX(short id, String stg, int hex) {
			ids = id;
			name = stg;
			colorHex = hex;
		}

	}

	public enum getEnumAllow {
		Bronze((short)256, "CuSn", 0xDB8B43), 
		Brass((short)257, "CuZn", 0xDB8B43), 
		Empty((short)32767, "", 0xFFFFFF);

		private short ids;
		private String name;
		private int color_hex;

		getEnumAllow(short id, String stg, int hex) {
			ids = id;
			name = stg;
			color_hex = hex;
		}

	}

	public PeriodicTable() {

	}

}
