package org.scoutant.tf.command;

import org.scoutant.tf.model.Country;
import org.scoutant.tf.model.Model;
import org.scoutant.tf.model.Pixel;
import org.scoutant.tf.model.Road;

import android.util.Log;

/**
 * During dev may use http://blog.scoutant.org/assets/markers.html
 *
 */
public class InitNetwork implements CommandWithInt {
	private static final String tag = "command";
	Country country = Model.model().country;

	@Override
	public void execute(int id) {
		Log.d(tag, ""+ id + "  ***************************************************************************************");
		
		switch ( id) {
		case 69:
			country.find(69)
			.done()
			.add( new Road( "Rocade Est vers le Nord")
				.set("45.7067,4.96735|45.70784,4.96756|45.71138,4.96854|45.71487,4.96984|45.7182,4.9713|45.71885,4.97162|45.71972,4.97216|45.72162,4.97359|45.72294,4.97444|45.72465,4.97529|45.72719,4.97629|45.72802,4.97673|45.7288,4.97717|45.73299,4.97986|45.73501,4.98137|45.74154,4.98702|45.74263,4.98775|45.74362,4.9882|45.74445,4.98842|45.74518,4.98851|45.74597,4.98852|45.74677,4.9884|45.74752,4.98819|45.7484,4.9878|45.75126,4.98612|45.75235,4.98576|45.75306,4.98564|45.77231,4.9848|45.77334,4.98462|45.7738,4.98442|45.77434,4.98407|45.77491,4.9836|45.77556,4.98279|45.77614,4.98171|45.7766,4.98036|45.77688,4.97854|45.77825,4.96502|45.77838,4.96427|45.7787,4.96305|45.77927,4.96148|45.77975,4.96042|45.78052,4.95921|45.78131,4.95826|45.78224,4.95742|45.78304,4.95687|45.78423,4.95631|45.78547,4.95603|45.78631,4.95599|45.78851,4.95619|45.78958,4.95604|45.79018,4.95582|45.79104,4.95533|45.79184,4.95465|45.79267,4.95364|45.79333,4.95255|45.7937,4.95176|45.7947,4.94919|45.79606,4.94532|45.79655,4.94356|45.79682,4.94217|45.79702,4.94018|45.79689,4.93809|45.79659,4.93656|45.79578,4.93385|45.79565,4.93276|45.7957,4.93182|45.79585,4.93126|45.79615,4.93052|45.7966,4.92984|45.79716,4.9294|45.79805,4.92901|45.79862,4.9287|45.79866,4.92861|45.80103,4.92757|45.80355,4.92625|45.80487,4.92577|45.80526,4.92546|45.80566,4.92491|45.806,4.92408|45.80876,4.91855|45.80948,4.91752|45.81023,4.91677|45.81067,4.91645|45.81145,4.91616|45.8123,4.91605|45.81283,4.91609|45.81342,4.91624|45.81404,4.9165|45.81643,4.9179|45.81724,4.91828|45.81822,4.91859|45.81894,4.91867|45.81954,4.91866|45.82305,4.91824|45.82379,4.91826|45.82516,4.91852|45.82642,4.91867|45.82861,4.91849|45.82975,4.91862|45.831,4.91865|45.8319,4.9185|45.83457,4.91759|45.83579,4.91736|45.83778,4.91719|45.83889,4.91693|45.84021,4.91633|45.84254,4.91473|45.84435,4.9137|45.85068,4.91063|45.85229,4.90992|45.85307,4.90964|45.85437,4.9093|45.85818,4.90874|45.86002,4.90827|45.86184,4.90764|45.86558,4.90597|45.86718,4.90535|45.86871,4.90498|45.87205,4.90432|45.87345,4.90388|45.87488,4.90327|45.87641,4.90238|45.87808,4.90113|45.88237,4.897|45.88387,4.89579|45.88599,4.89443|45.89148,4.89172|45.89259,4.89106|45.89379,4.8902|45.89494,4.88921|45.89578,4.88834|45.89685,4.88705|45.89796,4.88545|45.89854,4.88448|45.89938,4.88285|45.90012,4.8811|45.9007,4.87944|45.90121,4.87763|45.90285,4.87088|45.90366,4.86781|45.90415,4.86623|45.90486,4.86435|45.90577,4.86243|45.90821,4.85831|45.90897,4.85675|45.90971,4.85446|45.91004,4.85272|45.91016,4.85158|45.91021,4.84975|45.91012,4.84822|45.90984,4.84587|45.90949,4.84389|45.90895,4.84209|45.90853,4.84099|45.90734,4.83852|45.90652,4.83641|45.90609,4.83488|45.90526,4.83138|45.9035,4.82625|45.90324,4.82532|45.90294,4.82399|45.9025,4.82138|45.90205,4.81747|45.902,4.81614|45.90204,4.81465|45.90223,4.81298|45.9025,4.81151|45.90357,4.80652|45.90455,4.80337|45.90511,4.80203|45.90561,4.80097|45.90617,4.79998|45.90676,4.79911|45.90756,4.79816|45.90852,4.79724|45.90979,4.79635|45.91213,4.79504|45.9135,4.79394|45.91452,4.79281|45.91518,4.79187|45.91622,4.78998|45.917,4.78793|45.91746,4.78615|45.91768,4.78492|45.9182,4.77918|45.91868,4.77636|45.91934,4.77374|45.92016,4.77133|45.92058,4.77034|45.92159,4.76821|45.92397,4.76364|45.92521,4.7607|45.92587,4.75876|45.92655,4.75627|45.92699,4.75428|45.92807,4.74707|45.92858,4.74444|45.92925,4.74189|45.93017,4.73918")
				.add( new Pixel( 367, 278, 45.7067,4.96735))
				.add( 367, 268, 7182)
				.add( 374, 244, 7415)
				.add( 378, 230, 7475)
				.add( 376, 210, 7723)
				.add( 368, 198, 7761)
				.add( 353, 195, 7792)
				.add( 342, 184, 7918)
				.add( 332, 180, 7956)
			)
			.add( new Road( "Rocade Est vers le Sud")
				.set("45.93431,4.72902|45.92968,4.7402|45.9282,4.74569|45.92703,4.75344|45.92576,4.7587|45.92384,4.76365|45.9205,4.77026|45.91926,4.77369|45.91809,4.77915|45.91735,4.7861|45.9164,4.78923|45.9151,4.79176|45.91344,4.79381|45.90847,4.79711|45.90641,4.79937|45.90444,4.8033|45.9033,4.80719|45.90195,4.81464|45.90195,4.81753|45.90239,4.82152|45.90311,4.8253|45.90514,4.83149|45.90637,4.8365|45.90916,4.84319|45.90996,4.84803|45.91002,4.85141|45.90969,4.85382|45.90902,4.85618|45.90534,4.86296|45.90402,4.86612|45.90058,4.87932|45.89925,4.88274|45.89785,4.8853|45.89563,4.88822|45.89325,4.89037|45.88452,4.89506|45.88221,4.89691|45.87789,4.90104|45.8748,4.90314|45.87199,4.90419|45.86682,4.9053|45.86029,4.90802|45.85441,4.90913|45.85185,4.90994|45.84312,4.91418|45.83887,4.91676|45.83531,4.9173|45.83136,4.91846|45.82599,4.9185|45.82305,4.91811|45.81916,4.91852|45.81722,4.9181|45.81437,4.91649|45.8128,4.91593|45.8114,4.91599|45.81013,4.91667|45.80857,4.91859|45.8058,4.92411|45.80483,4.9253|45.80073,4.92753|45.79946,4.92767|45.79768,4.92728|45.79683,4.92762|45.79604,4.92848|45.79553,4.93006|45.79543,4.93212|45.79672,4.9375|45.79685,4.94115|45.79593,4.94547|45.79392,4.95104|45.79259,4.95362|45.79176,4.95461|45.79049,4.95556|45.78884,4.95608|45.78586,4.9559|45.78398,4.9563|45.78164,4.95778|45.77994,4.95992|45.77873,4.96255|45.77818,4.96485|45.77649,4.98035|45.77565,4.9824|45.77437,4.98387|45.77353,4.98436|45.77233,4.98464|45.75297,4.98554|45.75124,4.986|45.74717,4.98819|45.74554,4.98843|45.74401,4.98821|45.74175,4.98708|45.73385,4.98032|45.72818,4.97665|45.72314,4.97441|45.71936,4.97175|45.71607,4.97018|45.71134,4.96836|45.70267,4.9659")
				.add( 184, 72, 9343)
				.add( 212, 79, 9205)
				.add( 223, 80, 9164)
				.add( new Pixel( 237, 89, 45.90195,4.81464))
				.add( 265, 81, 9091)
				.add( 286, 85, 9053)
				.add( 296, 102, 8668)
				.add( 314, 124, 8431)
				.add( 315, 161, 8143)
				.add( 320, 169, 8007)
				.add( 339, 186, 7959)
				.add( 351, 199, 7816)
				.add( 366, 202, 7743)
				.add( 372, 216, 7529)
				.add( 373, 237, 7417)
				.add( 365, 258, 7193)
				.add( 363, 275, 7026)
				)
			.add( new Road( "A7 dir Sud")
				.set("45.99682,4.73612|45.9921,4.73686|45.98119,4.73671|45.97876,4.736|45.97651,4.73471|45.97357,4.73171|45.957,4.71784|45.95466,4.71665|45.95298,4.71616|45.95098,4.71597|45.94923,4.71612|45.94636,4.71706|45.94397,4.71857|45.94165,4.72086|45.93699,4.72635|45.93534,4.72754|45.93403,4.72812|45.93223,4.72841|45.93042,4.72821|45.929,4.72764|45.92509,4.72537|45.92315,4.72499|45.92088,4.72527|45.90564,4.72838|45.90115,4.72958|45.8978,4.73092|45.8836,4.73788|45.87992,4.73914|45.87626,4.73985|45.86029,4.74134|45.8567,4.74208|45.85446,4.74283|45.85021,4.74484|45.84696,4.74699|45.84427,4.74922|45.83612,4.7571|45.83087,4.76077|45.82589,4.76299|45.80643,4.76929|45.80443,4.77021|45.80256,4.77176|45.79336,4.7811|45.79045,4.78308|45.7873,4.78457|45.78559,4.78478|45.78399,4.78397|45.7819,4.7817|45.78071,4.78076|45.77924,4.78048|45.77822,4.78077|45.77705,4.78173|45.77383,4.78554|45.77029,4.79212|45.76228,4.80454|45.76078,4.80811|45.75153,4.82105|45.74904,4.82826|45.74795,4.82984|45.73101,4.81561|45.73022,4.81535|45.72854,4.81611|45.71948,4.81847|45.71427,4.82135|45.71188,4.82397|45.70938,4.82863|45.70389,4.8341|45.70226,4.8351|45.69895,4.83592|45.69768,4.83683|45.69676,4.83803|45.69361,4.84355|45.69205,4.84506|45.6843,4.84694|45.6772,4.84788|45.6738,4.84762|45.67144,4.8469|45.66496,4.84356|45.65824,4.84077|45.65449,4.83868|45.64835,4.8336|45.63903,4.82414|45.63514,4.82094|45.6291,4.81718|45.61855,4.81191|45.61273,4.80798|45.60954,4.80491|45.60487,4.79911|45.60289,4.79715|45.60152,4.79632|45.59998,4.79587|45.59642,4.79612|45.59064,4.79749|45.5867,4.79902|45.58069,4.80204|45.57787,4.80367|45.57607,4.80505|45.57419,4.8075|45.572,4.81191|45.57014,4.81431|45.56789,4.81627|45.5631,4.81913|45.55863,4.82281|45.55285,4.82835|45.54841,4.83375|45.54583,4.83804|45.54378,4.84306|45.54324,4.84575|45.54333,4.85111|45.54284,4.85277|45.54217,4.85392|45.54096,4.85504|45.5353,4.85763|45.53131,4.86074|45.53,4.86138|45.52819,4.86177|45.5256,4.86136|45.52156,4.85949|45.51854,4.85908|45.51668,4.85815|45.51505,4.85614|45.51201,4.849|45.50804,4.84485|45.50546,4.84025|45.50438,4.83937|45.50321,4.83897")
				.add( 181, 14, 9968)
				.add( 166, 47, 9463)
				.add( 174, 63, 9322)
				.add( 172, 80, 9208)
				.add( 181, 107, 8762)
				.add( 183, 121, 8502)
				.add( 199, 143, 8258)
				.add( 203, 163, 8064)
				.add( 208, 175, 8025)
				.add( 219, 189, 7904)
				.add( 220, 205, 7807)
				.add( 227, 215, 7738)
				.add( 249, 234, 7515)
				.add( 250, 241, 7479)
				.add( 244, 252, 7310)
				.add( 245, 263, 7194)
				.add( 258, 283, 7038)
				.add( 268, 297, 6936)
				.add( 268, 319, 6772)
				.add( 264, 343, 6582)
				.add( 250, 361, 6390)
				.add( 236, 393, 6048)
				.add( 240, 408, 5867)
				.add( 256, 424, 5586)
				.add( 270, 430, 5409)
				.add( 274, 438, 5281)
				.add( 272, 455, 5032)
			)
			.add( new Road( "A7 dir Nord")
				.set("45.50507,4.84002|45.50592,4.84105|45.50792,4.84481|45.51189,4.84899|45.51496,4.85613|45.51685,4.85839|45.51856,4.85922|45.52156,4.85964|45.52558,4.86148|45.52714,4.86186|45.52868,4.86185|45.53136,4.86087|45.53534,4.85775|45.54083,4.85525|45.54228,4.85405|45.54296,4.85288|45.54347,4.85115|45.54334,4.84578|45.54374,4.84367|45.5455,4.83908|45.54818,4.83434|45.55247,4.82898|45.5587,4.82295|45.56347,4.81907|45.56794,4.81644|45.57022,4.81446|45.5721,4.81203|45.57432,4.80758|45.57615,4.80521|45.57796,4.80383|45.58073,4.80223|45.58846,4.79847|45.59429,4.79671|45.59949,4.79602|45.60148,4.7965|45.60328,4.79768|45.6101,4.80571|45.61435,4.80943|45.62052,4.81319|45.63042,4.81812|45.63622,4.82197|45.64014,4.82546|45.64828,4.83377|45.65251,4.83743|45.65496,4.8392|45.65819,4.84095|45.66433,4.84348|45.67139,4.84709|45.67303,4.84764|45.67694,4.8481|45.68431,4.84714|45.69147,4.84548|45.69272,4.84476|45.69384,4.84344|45.6976,4.83715|45.69899,4.83611|45.7023,4.83532|45.704,4.83427|45.70934,4.82908|45.7123,4.82377|45.7147,4.82133|45.71998,4.8185|45.72774,4.81653|45.73017,4.81549|45.73094,4.8157|45.74751,4.8299|45.74806,4.82996|45.74911,4.82838|45.75166,4.82108|45.75366,4.81887|45.76078,4.80913|45.76275,4.80421|45.77058,4.79182|45.7736,4.78608|45.77772,4.78131|45.77916,4.78068|45.78063,4.78095|45.7842,4.78437|45.78579,4.78504|45.78703,4.7849|45.79053,4.78323|45.79343,4.78126|45.80205,4.77249|45.8043,4.77056|45.80626,4.76965|45.8266,4.76301|45.83104,4.76097|45.8364,4.75717|45.84644,4.74769|45.84904,4.74583|45.85271,4.7438|45.8563,4.74244|45.86013,4.7416|45.87613,4.74013|45.88004,4.73938|45.88363,4.73811|45.89786,4.73119|45.90119,4.72985|45.90567,4.72866|45.92187,4.72531|45.92317,4.7252|45.92503,4.72555|45.93038,4.72838|45.93224,4.72859|45.93405,4.72829|45.93591,4.72739|45.93706,4.7265|45.94168,4.7211|45.94405,4.71876|45.94642,4.71727|45.94846,4.71652|45.95098,4.71619|45.95296,4.71638|45.95462,4.71686|45.95694,4.71804|45.97052,4.72961|45.97311,4.73279|45.97776,4.73575|45.98085,4.73688|45.9921,4.73708|45.99685,4.73634")
				.add( 277, 456, 5050)
				.add( 279, 437, 5255)
				.add( 275, 427, 5408)
				.add( 263, 421, 5587)
				.add( 245, 404, 5884)
				.add( 242, 390, 6101)
				.add( 257, 361, 6401)
				.add( 267, 349, 6549)
				.add( 271, 337, 6730)
				.add( 273, 317, 6914)
				.add( 273, 296, 6989)
				.add( 253, 268, 7147)
				.add( 250, 252, 7277)
				.add( 256, 239, 7475)
				.add( 252, 231, 7516)
				.add( 234, 214, 7705)
				.add( 226, 205, 7777)
				.add( 225, 188, 7870)
				.add( 212, 169, 8043)
				.add( 204, 143, 8266)
				.add( 188, 119, 8490)
				.add( 182,  93, 8761)
				.add( 177,  78, 9218)
				.add( 180,  62, 9340)
				.add( 173,  48, 9484)
				.add( 176,  32, 9731)
				.add( 185,  16, 9968)
			)
			.add( new Road( "Périphérique dir Nord")
				.set("45.69631,4.84492|45.69746,4.84535|45.69775,4.84537|45.69887,4.84563|45.69973,4.84567|45.7009,4.84556|45.70136,4.84546|45.70211,4.84519|45.7038,4.84439|45.70416,4.84426|45.70542,4.84397|45.70573,4.84398|45.70949,4.84366|45.71243,4.84333|45.71408,4.84325|45.71525,4.84331|45.71559,4.84352|45.71573,4.84373|45.71581,4.84397|45.71592,4.84472|45.71637,4.84984|45.71719,4.8581|45.71884,4.87568|45.71903,4.87713|45.71924,4.8782|45.71954,4.87933|45.7205,4.88225|45.72153,4.88568|45.72198,4.88699|45.72285,4.88921|45.72391,4.89243|45.72417,4.89405|45.72419,4.89477|45.72433,4.8953|45.72453,4.89567|45.72486,4.89603|45.72537,4.89625|45.72625,4.89646|45.72652,4.8966|45.73073,4.89952|45.73085,4.8995|45.733,4.90063|45.73403,4.90124|45.73603,4.90275|45.73821,4.90421|45.73856,4.90439|45.74078,4.90519|45.74606,4.90664|45.75805,4.90914|45.76038,4.90968|45.76184,4.9099|45.76235,4.90985|45.76276,4.90967|45.76342,4.90911|45.7658,4.90652|45.77002,4.90285|45.78079,4.89403|45.78474,4.89066|45.7889,4.88611|45.79086,4.88385|45.79169,4.88277|45.79225,4.88191|45.7928,4.88097|45.79323,4.88001|45.79354,4.87891|45.79366,4.87794|45.79366,4.87679|45.79348,4.8755|45.79148,4.86978|45.79104,4.869|45.7902,4.86779|45.78952,4.86605|45.78868,4.86453|45.78837,4.86352|45.78819,4.86252|45.78812,4.8618|45.78812,4.8607|45.78838,4.85443|45.78862,4.85249|45.78904,4.85069|45.79005,4.84772|45.79073,4.84467|45.79244,4.8357|45.79377,4.82808|45.79404,4.82512|45.79399,4.82279|45.79386,4.82168|45.79338,4.81949|45.79229,4.81626|45.79076,4.81268|45.78981,4.80946|45.78948,4.8086|45.78879,4.80721|45.78805,4.80617|45.78736,4.80542|45.78676,4.8049|45.78449,4.80336|45.7842,4.80307|45.78302,4.80119|45.78183,4.79983|45.78135,4.79918|45.77823,4.7936|45.77705,4.79194|45.77665,4.79144|45.77602,4.7909|45.77506,4.79046|45.77277,4.78977|45.77198,4.7893")
				.add( 274, 288, 6963)
				.add( 274, 275, 7124)
				.add( 274, 288, 7159)
				.add( 294, 268, 7188)
				.add( 308, 260, 7228)
				.add( 314, 247, 7340)
				.add( 317, 235, 7460)
				.add( 316, 216, 7658)
				.add( 306, 198, 7807)
				.add( 292, 184, 7928)
				.add( new Pixel(276, 186, 45.78812,4.8618))
				.add( 249, 181, 7933)
				.add( 241, 184, 7867)
				.add( 230, 200, 7719)
			)
			.add( new Road( "Périphérique dir Sud")
				.set("45.77202,4.78963|45.77284,4.78999|45.77521,4.79084|45.77587,4.79116|45.77648,4.79162|45.77704,4.79224|45.77793,4.79343|45.78094,4.79869|45.78166,4.79974|45.78296,4.80124|45.78374,4.80266|45.78411,4.80321|45.78489,4.80385|45.78667,4.80503|45.78761,4.80594|45.78838,4.80691|45.78891,4.80782|45.78934,4.80876|45.79076,4.81301|45.79214,4.8161|45.79269,4.81756|45.79331,4.81955|45.79358,4.82062|45.79391,4.82262|45.79397,4.825|45.79381,4.82706|45.79343,4.82956|45.79132,4.84087|45.79072,4.84374|45.78948,4.84876|45.7887,4.85117|45.78855,4.85183|45.78838,4.85296|45.78828,4.85441|45.78803,4.86107|45.78805,4.86202|45.78816,4.86294|45.78873,4.8654|45.78906,4.86638|45.78936,4.86693|45.79014,4.86786|45.79071,4.86867|45.79146,4.86992|45.79291,4.87399|45.79333,4.87533|45.79355,4.87665|45.79356,4.87794|45.79342,4.87894|45.79311,4.88004|45.79265,4.88101|45.79196,4.88216|45.79096,4.88354|45.78708,4.88792|45.7844,4.89081|45.78255,4.89241|45.76997,4.90269|45.76593,4.9062|45.76308,4.90919|45.76258,4.90952|45.76226,4.90964|45.76181,4.90966|45.76118,4.90958|45.75925,4.90924|45.74607,4.90647|45.74401,4.90592|45.74226,4.9053|45.73859,4.90418|45.73747,4.90344|45.73365,4.90045|45.73124,4.8991|45.7299,4.89843|45.7285,4.8977|45.7274,4.8962|45.72678,4.89485|45.72617,4.89369|45.72594,4.89336|45.72558,4.89302|45.72509,4.89276|45.72465,4.89245|45.72421,4.89199|45.72389,4.89151|45.72353,4.89071|45.72297,4.88906|45.72168,4.8857|45.72064,4.88217|45.71956,4.87887|45.71923,4.87741|45.71904,4.87619|45.71675,4.85248|45.71603,4.84463|45.71601,4.84417|45.71615,4.84324|45.71612,4.84294|45.71591,4.8426|45.71563,4.84251|45.71542,4.84258|45.71511,4.8428|45.71479,4.84294|45.71395,4.8431|45.71225,4.84319|45.70924,4.84352|45.70537,4.84384|45.70415,4.84413|45.70209,4.84507|45.70157,4.84525|45.70112,4.84536|45.7,4.8455|45.69888,4.84547|45.69814,4.84533|45.69748,4.84515|45.6961,4.84453|45.69565,4.8444|45.69484,4.84433|45.69399,4.84446")
				.add( 232, 206, 7720)
				.add( 245, 187, 7889)
				.add( new Pixel(250, 185, 45.79358,4.82062))
				.add( new Pixel(272, 191, 45.78803,4.86107))
				.add( new Pixel(287, 190, 45.79342,4.87894))
				.add( 297, 195, 7870)
				.add( 312, 219, 7659)
				.add( 312, 237, 7440)
				.add( 307, 251, 7312)
				.add( 299, 260, 7229)
				.add( 288, 264, 7190)
				.add( 272, 267, 7167)
				.add( 267, 273, 7092)
				.add( 232, 206, 6939)
			)
			.add( new Road( "A42 vers l'Est")
				.set("45.78335,4.89266|45.78356,4.89326|45.78406,4.89526|45.78459,4.89662|45.78494,4.89721|45.78551,4.898|45.78771,4.90029|45.78847,4.90121|45.78895,4.90203|45.78944,4.90315|45.78967,4.90394|45.79478,4.92625|45.79496,4.92688|45.79521,4.92748|45.79575,4.92821|45.79606,4.9285|45.7964,4.92872|45.79698,4.92894|45.79755,4.92894|45.79817,4.92879|45.7991,4.92845|45.80014,4.928|45.80382,4.92614|45.80469,4.92616|45.80522,4.92636|45.80586,4.92679|45.80646,4.9274|45.807,4.92817|45.80725,4.92862|45.80817,4.93047|45.80895,4.9323|45.81004,4.93517|45.81039,4.93624|45.81163,4.9403|45.81267,4.94439|45.81328,4.94719|45.81413,4.95197|45.8145,4.95458|45.81482,4.95731|45.81598,4.97041|45.81671,4.97718|45.81715,4.98037|45.8177,4.98378|45.81812,4.98599|45.81847,4.9874|45.81937,4.99041|45.82014,4.99324|45.8204,4.99401|45.82119,4.99555|45.82183,4.99655|45.82236,4.99786|45.82314,5.00076|45.82531,5.00984|45.8259,5.01214|45.82661,5.01461|45.82712,5.01615|45.82791,5.01826|45.82873,5.02021|45.83356,5.03049|45.83487,5.03344|45.83568,5.03541|45.8367,5.0381|45.83793,5.04183|45.83871,5.04459|45.83992,5.04981|45.84255,5.06335|45.84323,5.06655|45.84414,5.0705|45.84544,5.07539|45.8467,5.07909|45.85044,5.08873|45.85145,5.09174|45.85243,5.09504|45.8556,5.10727|45.85671,5.11128|45.85759,5.1143|45.85878,5.1181|45.86282,5.13029|45.86331,5.13206|45.86367,5.13371|45.86396,5.13541|45.86412,5.13671")
				.add( 307, 193 , 7833)
				.add( 324, 185 , 7947)
				.add( 330, 171 , 8081)
				.add( 365, 157 , 8159)
				.add( 401, 146 , 8271)
				.add( 421, 129 , 8467)
				.add( 439, 126 , 8641)
			)
			.add( new Road( "A42 vers l'Oeust")
				.set("45.86185,5.17272|45.86173,5.17021|45.86177,5.16726|45.86195,5.16468|45.86237,5.16091|45.86373,5.15046|45.86411,5.14717|45.86434,5.14469|45.86447,5.14206|45.86449,5.14056|45.86444,5.13903|45.86427,5.13668|45.86393,5.13427|45.86353,5.13231|45.86323,5.13112|45.86211,5.12751|45.85894,5.11799|45.85687,5.11119|45.85576,5.1072|45.85306,5.09666|45.85178,5.0922|45.85058,5.08857|45.84683,5.07891|45.8462,5.0771|45.8449,5.07291|45.84411,5.06985|45.84317,5.06559|45.84052,5.05184|45.83967,5.04782|45.83885,5.04446|45.83784,5.04093|45.83697,5.0383|45.836,5.03573|45.835,5.03332|45.83284,5.02852|45.82905,5.02049|45.82805,5.01814|45.82727,5.01605|45.82676,5.01452|45.82604,5.01206|45.8233,5.00068|45.82241,4.99743|45.82172,4.99551|45.82115,4.99431|45.81978,4.99102|45.81915,4.98918|45.81862,4.98741|45.81823,4.98582|45.81782,4.98374|45.81731,4.98052|45.81676,4.97645|45.81612,4.97038|45.81496,4.95728|45.81433,4.95231|45.8136,4.94808|45.8128,4.94433|45.81222,4.9419|45.81144,4.9391|45.81052,4.93615|45.80949,4.93322|45.80816,4.92993|45.8075,4.92721|45.80725,4.92642|45.80681,4.92568|45.80658,4.92542|45.80626,4.92516|45.80577,4.92492|45.80556,4.92487|45.80529,4.92485|45.80482,4.92494|45.80442,4.92513|45.80351,4.9259|45.80249,4.9265|45.80091,4.92727|45.80024,4.92747|45.79995,4.92751|45.79922,4.92742|45.79836,4.92705|45.79741,4.9263|45.79671,4.92585|45.79531,4.9253|45.79482,4.9248|45.79457,4.92429|45.7943,4.92354|45.79032,4.9061|45.78961,4.90328|45.78948,4.90291|45.7892,4.90219|45.78855,4.90107|45.78781,4.90018|45.78639,4.89878|45.78565,4.89797|45.78516,4.89731|45.78474,4.89664|45.78447,4.89606|45.78415,4.89518|45.78361,4.89311|45.78352,4.89258")
				.add( 436, 121 , 8618)
				.add( 416, 125 , 8517)
				.add( 396, 142 , 8290)
				.add( 362, 153 , 8173)
				.add( 325, 169 , 8075)
				.add( 321, 182 , 7943)
				.add( 439, 126 , 7835)
			)
			.add( new Road( "A43 vers l'Est")
				.set("45.7290,4.8989|45.72698,4.91217|45.72584,4.91965|45.72553,4.92128|45.7249,4.92393|45.72432,4.92592|45.72335,4.92865|45.72208,4.93154|45.72109,4.93352|45.71998,4.93554|45.71784,4.93894|45.71257,4.94699|45.71046,4.95045|45.70857,4.95387|45.70624,4.95858|45.70146,4.9693|45.69936,4.97365|45.69693,4.97826|45.69441,4.98271|45.69023,4.98991|45.68851,4.99331|45.68706,4.99662|45.6862,4.99886|45.68491,5.00277|45.68397,5.00616|45.68146,5.01645|45.68046,5.02017|45.67942,5.02361|45.6782,5.02724|45.67599,5.03301")
				.add( 316, 258 , 7290)
				.add( 332, 266 , 7255)
				.add( 358, 282 , 7062)
				.add( 388, 307 , 6862)
				.add( 402, 315 , 6759)
			)
			.add( new Road( "A43 vers l'Ouest")
				.set("45.67611,5.03315|45.67786,5.02868|45.67869,5.02631|45.68016,5.02177|45.68086,5.01934|45.68222,5.01408|45.6836,5.00832|45.6845,5.0048|45.68573,5.00075|45.68677,4.99783|45.68762,4.99575|45.68872,4.99325|45.69027,4.99019|45.69572,4.98074|45.69725,4.97802|45.69905,4.97465|45.70158,4.96941|45.70631,4.95881|45.70755,4.95623|45.70871,4.95395|45.71061,4.9505|45.71246,4.94747|45.71867,4.93795|45.72076,4.93452|45.72212,4.93194|45.72276,4.93052|45.72342,4.92886|45.72445,4.92592|45.72512,4.92359|45.72565,4.9213|45.72618,4.91846|45.72695,4.91328|45.72883,4.89977")
				.add( 408, 312 , 6761)
				.add( 389, 301 , 6902)
				.add( 358, 276 , 7087)
				.add( 335, 260 , 7244)
				.add( 317, 253 , 7288)
			)
			;
			break;

		case 38:
			country.find(38)
			.done()
			.add( new Road("GrenobleSO")
				.set( "45.20512,5.78348|45.2019,5.7817|45.20187,5.78164|45.2002,5.78073|45.19986,5.7806|45.19918,5.78051|45.19859,5.78058|45.19775,5.78089|45.19599,5.78165|45.19548,5.78182|45.19466,5.78199|45.19368,5.78205|45.18955,5.78193|45.18745,5.78166|45.18628,5.78134|45.18515,5.7809|45.18456,5.78059|45.18315,5.77967|45.1822,5.77887|45.1813,5.77793|45.18056,5.77702|45.17958,5.77564|45.17868,5.77409|45.17666,5.77003|45.17551,5.76792|45.17477,5.76672|45.17395,5.76553|45.17341,5.76478|45.1726,5.76378|45.17113,5.76214|45.16993,5.76097|45.16642,5.75796|45.16473,5.75629|45.15705,5.74799|45.15621,5.74698|45.15554,5.74607|45.15459,5.74454|45.1534,5.74228|45.15261,5.74041|45.15178,5.73789|45.15136,5.73616|45.15094,5.73363|45.15075,5.73138|45.15072,5.72872|45.15087,5.72641|45.15115,5.72449|45.1519,5.72082|45.15219,5.71887|45.15237,5.7182|45.15273,5.71731|45.15295,5.7169|45.15335,5.71634|45.15499,5.71453|45.15595,5.71361|45.15659,5.71312|45.15727,5.71238|45.15785,5.71145|45.15806,5.71103|45.15837,5.7102|45.1586,5.70927|45.15872,5.70832|45.15875,5.70579|45.15868,5.70337|45.15884,5.70283|45.15956,5.70141")
				.add( new Pixel( 370, 140, 45.20187,5.78164))
				.add( new Pixel( 369, 159, 45.18745,5.78166))
				.add( new Pixel( 357, 188, 45.18056,5.77702))
				.add( new Pixel( 341, 205, 45.17958,5.77564))
				.add( new Pixel( 330, 220, 45.17341,5.76478))
				.add( new Pixel( 293, 280, 45.15705,5.74799))
				.add( new Pixel( 274, 302, 45.15459,5.74454))
				.add( new Pixel( 254, 315, 45.15178,5.73789))
				.add( new Pixel( 228, 320, 45.15075,5.73138))
				.add( new Pixel( 200, 320, 45.1519,5.72082))
				.add( new Pixel( 180, 317, 45.15273,5.71731))
				.add( new Pixel( 154, 302, 45.15837,5.7102))
			)
			.add( new Road("GrenobleSE")
				.set( "45.15757,5.70092|45.15805,5.70221|45.15835,5.7028|45.15859,5.70383|45.15866,5.70508|45.15864,5.70817|45.15847,5.70949|45.1582,5.71047|45.15784,5.7113|45.15727,5.71215|45.15633,5.71307|45.15529,5.71395|45.15484,5.71442|45.15344,5.71599|45.1529,5.71672|45.15255,5.71733|45.15232,5.71785|45.15204,5.71883|45.15114,5.72364|45.15084,5.72559|45.15064,5.72825|45.15061,5.73067|45.15068,5.73198|45.15086,5.7338|45.15127,5.73623|45.15173,5.73818|45.1525,5.74058|45.15308,5.742|45.15369,5.74327|45.15426,5.74431|45.15536,5.74609|45.1561,5.74713|45.15764,5.74884|45.16016,5.75152|45.16218,5.75378|45.16544,5.75722|45.17091,5.76214|45.17163,5.76288|45.17335,5.76493|45.1744,5.76636|45.17582,5.76866|45.17867,5.77428|45.17948,5.7757|45.18034,5.77695|45.18144,5.77826|45.18218,5.77901|45.183,5.77971|45.18363,5.78019|45.1841,5.78048|45.18554,5.78122|45.18709,5.78172|45.18803,5.78192|45.18968,5.78209|45.19385,5.78215|45.19464,5.7821|45.19542,5.78197|45.19616,5.78176|45.19833,5.7808|45.19885,5.78068|45.19961,5.78071|45.20022,5.7809|45.20183,5.78177|45.20186,5.78183|45.20323,5.78272|45.20363,5.78306|45.2038,5.78327|45.20422,5.78408")
				.add( new Pixel(154, 308 , 45.15757,5.70092))
				.add( new Pixel( 164, 306, 45.15864,5.70817))
				.add( new Pixel( 187, 321, 45.1529,5.71672))
				.add( new Pixel( 198, 324, 45.15204,5.71883))
				.add( new Pixel(231, 325, 45.15064,5.72825))
				.add( new Pixel(248, 322, 45.15127,5.73623))
				.add( new Pixel(270, 312, 45.15536,5.74609))
				.add( new Pixel(290, 296, 45.16016,5.75152))
				.add( new Pixel(303, 279, 45.16544,5.75722))
				.add( new Pixel(320, 248, 45.17163,5.76288))
				.add( new Pixel(346, 209, 45.17867,5.77428))
				.add( new Pixel(366, 186, 45.1841,5.78048))
				.add( new Pixel(374, 166, 45.18968,5.78209))
				.add( new Pixel(376, 142, 45.19542,5.78197))
				.add( new Pixel(372, 122, 45.20422,5.78408))
			)
			.add( new Road("A480S")
				.set( "45.23864,5.66103|45.23695,5.662|45.2327,5.66417|45.23135,5.66497|45.22961,5.66612|45.22257,5.67134|45.22123,5.67238|45.22001,5.67345|45.21852,5.67513|45.21773,5.67633|45.21688,5.67785|45.2148,5.68195|45.21426,5.68283|45.21379,5.68343|45.21303,5.68416|45.21216,5.68474|45.20949,5.68606|45.20863,5.68657|45.20768,5.68728|45.20708,5.68786|45.20656,5.68844|45.2056,5.68971|45.19853,5.69983|45.19789,5.70067|45.19728,5.70131|45.19664,5.70182|45.1961,5.70216|45.19513,5.70258|45.19439,5.70275|45.19373,5.70282|45.19243,5.70282|45.18749,5.70253|45.18096,5.70239|45.1785,5.70229|45.17584,5.70211|45.16318,5.70155|45.16082,5.70149|45.15956,5.70141|45.15914,5.70133|45.15866,5.70116|45.15818,5.70091|45.15652,5.69972|45.15558,5.69918|45.14173,5.69259|45.13903,5.69133|45.13815,5.691|45.13733,5.69074|45.13633,5.6905|45.1338,5.69005|45.13303,5.69|45.13233,5.69002|45.13147,5.69018|45.1295,5.69081|45.12884,5.69097|45.12838,5.69102|45.12754,5.69101|45.12719,5.69094|45.12604,5.69051|45.12348,5.68906|45.11934,5.68633|45.11484,5.68344|45.11389,5.68291|45.11193,5.68201|45.11136,5.68167|45.11056,5.68109|45.10858,5.6793|45.1076,5.6786|45.09996,5.67464|45.09915,5.67407|45.09872,5.67371|45.09697,5.67193|45.09638,5.6714|45.09548,5.67075|45.09443,5.67018|45.09395,5.67|45.09165,5.66922|45.09054,5.66891|45.0901,5.66888")
				.add( new Pixel( 30, 31, 45.23864,5.66103))
				.add( new Pixel( 45, 56, 45.22961,5.66612))
				.add( new Pixel( 56, 72, 45.22001,5.67345))
				.add( new Pixel( 70, 92, 45.21688,5.67785))
				.add( new Pixel( 96, 122, 45.2056,5.68971))
				.add( new Pixel(134, 152, 45.19789,5.70067))
				.add( new Pixel( 144, 163, 45.19243,5.70282))
				.add( new Pixel(142, 292, 45.16082,5.70149))
				.add( new Pixel(144, 303, 45.15866,5.70116))
				.add( new Pixel(124, 354, 45.14173,5.69259))
				.add( new Pixel(122, 371, 45.13633,5.6905))
				.add( new Pixel(121, 389, 45.12604,5.69051))
				.add( new Pixel(117, 406, 45.11934,5.68633))
				.add( new Pixel(101, 436, 45.09395,5.67))
				.add( new Pixel(98, 446, 45.0901,5.66888))
			)
			.add( new Road("A480N")
				.set( "45.09041,5.66918|45.09114,5.66933|45.09354,5.67009|45.09444,5.67043|45.09518,5.67081|45.0964,5.67169|45.0986,5.6739|45.09955,5.67464|45.10131,5.67563|45.10741,5.67876|45.10814,5.67924|45.11037,5.6812|45.11104,5.6817|45.11172,5.6821|45.11395,5.68311|45.11455,5.68346|45.11872,5.68614|45.12206,5.68846|45.12285,5.68894|45.1258,5.69051|45.12657,5.69086|45.12721,5.69105|45.12861,5.69115|45.12933,5.691|45.13097,5.69047|45.13176,5.69028|45.13279,5.69019|45.13387,5.69028|45.13777,5.691|45.1393,5.69161|45.1415,5.69263|45.15512,5.69911|45.15629,5.69971|45.15822,5.70109|45.15894,5.70143|45.1594,5.70154|45.16022,5.70161|45.17637,5.70226|45.18013,5.70251|45.18856,5.70275|45.19237,5.70297|45.19372,5.70297|45.19457,5.70287|45.19516,5.70273|45.19616,5.70232|45.19696,5.70179|45.19797,5.7008|45.20567,5.68982|45.20662,5.68856|45.20714,5.68799|45.20767,5.68747|45.20868,5.6867|45.2102,5.68586|45.2122,5.68488|45.21311,5.68429|45.21389,5.68353|45.21434,5.68294|45.21488,5.68206|45.21679,5.67823|45.21786,5.67636|45.21883,5.67503|45.21948,5.67425|45.22056,5.67319|45.2227,5.67149|45.23033,5.6659|45.23154,5.66512|45.23349,5.66399|45.23669,5.66237|45.23794,5.66167")
				.add( new Pixel( 104, 458, 45.09041,5.66918))
				.add( new Pixel( 105, 444, 45.0964,5.67169))
				.add( new Pixel( 114, 426, 45.10741,5.67876))
				.add( new Pixel( 124, 408, 45.1258,5.69051))
				.add( new Pixel( 128, 396, 45.12861,5.69115))
				.add( new Pixel( 128, 368, 45.13387,5.69028))
				.add( new Pixel( 131, 354, 45.1393,5.69161))
				.add( new Pixel( 142, 324, 45.15512,5.69911))
				.add( new Pixel( 150, 306, 45.15894,5.70143))
				.add( new Pixel( 148, 244, 45.17637,5.70226))
				.add( new Pixel( 152, 170, 45.19237,5.70297))
				.add( new Pixel( 150, 158, 45.19797,5.7008))
				.add( new Pixel( 110, 124, 45.20567,5.68982))
				.add( new Pixel(  89, 105, 45.2122,5.68488))
				.add( new Pixel(  69,  82, 45.21786,5.67636))
				.add( new Pixel(  52,  57, 45.23033,5.6659))
				.add( new Pixel(  36,  29, 45.23794,5.66167))
			)
			.add( new Road("GrenobleBastilleE")
				.set( "45.21244,5.68565|45.21204,5.68708|45.21154,5.68946|45.21092,5.69346|45.2106,5.69518|45.21023,5.69687|45.20964,5.69893|45.20906,5.70062|45.20607,5.70806|45.20523,5.71056|45.20483,5.71138|45.20435,5.71206|45.20184,5.71525|45.20115,5.71587|45.20081,5.71609|45.20023,5.71634|45.19984,5.71641|45.19951,5.71641|45.19873,5.71629|45.19721,5.71586|45.19652,5.71586|45.19577,5.71607|45.19509,5.71645|45.19454,5.71688|45.19405,5.71752|45.19384,5.71799")
				.add( new Pixel( 88, 98, 45.21244,5.68565))
				.add( new Pixel( 101, 93, 45.2106,5.69518))
				.add( new Pixel( 119, 102, 45.20964,5.69893))
				.add( new Pixel( 140, 109, 45.20607,5.70806))
				.add( new Pixel( 160, 113, 45.20184,5.71525))
				.add( new Pixel( 174, 120, 45.19951,5.71641))
				.add( new Pixel( 182, 138, 45.19577,5.71607))
				.add( new Pixel( 185, 151, 45.19384,5.71799))
			)
			.add( new Road("GrenobleBastilleO")
				.set( "45.19401,5.71788|45.19412,5.71756|45.19449,5.71705|45.19473,5.71681|45.19546,5.71631|45.19616,5.71604|45.19671,5.71596|45.1972,5.71598|45.19871,5.71643|45.19952,5.71658|45.20026,5.71651|45.20049,5.71644|45.20102,5.71617|45.20148,5.71582|45.20213,5.71516|45.20443,5.71218|45.20491,5.71148|45.20532,5.71064|45.20635,5.70765|45.20915,5.70069|45.21022,5.69766|45.211,5.6949|45.21232,5.68886|45.21292,5.68688|45.21346,5.68546")
				.add( new Pixel( 191, 154, 45.19401,5.71788))
				.add( new Pixel( 183, 148, 45.19546,5.71631))
				.add( new Pixel( 180, 130, 45.19871,5.71643))
				.add( new Pixel( 172, 119, 45.20102,5.71617))
				.add( new Pixel( 161, 112, 45.20532,5.71064))
				.add( new Pixel( 143, 110, 45.20915,5.70069))
				.add( new Pixel( 110, 96, 45.211,5.6949))
				.add( new Pixel( 82, 92, 45.21346,5.68546))
				.set( "45.19401,5.71788|45.19412,5.71756|45.19449,5.71705|45.19473,5.71681|45.19546,5.71631|45.19616,5.71604|45.19671,5.71596|45.1972,5.71598|45.19871,5.71643|45.19952,5.71658|45.20026,5.71651|45.20049,5.71644|45.20102,5.71617|45.20148,5.71582|45.20213,5.71516|45.20443,5.71218|45.20491,5.71148|45.20532,5.71064|45.20635,5.70765|45.20915,5.70069|45.21022,5.69766|45.211,5.6949|45.21232,5.68886|45.21292,5.68688|45.21346,5.68546")
			);
			break;
		default:
			break;
		}
		
		Log.d(tag, ""+country);
	}
}