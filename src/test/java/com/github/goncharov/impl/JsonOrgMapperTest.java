package com.github.goncharov.impl;

import com.github.goncharov.JsonMapper;
import com.github.goncharov.entities.PhotoResponse;
import com.github.goncharov.entities.PhotoStream;
import com.github.goncharov.entities.UserProfile;
import com.github.goncharov.enums.Locale;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Goncharov
 * Date: 17.06.12
 * Time: 12:07
 */
public class JsonOrgMapperTest extends TestCase {
    private JsonMapper mapper;

    private static final String USER_TEST_1 = "{\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"birthday\":null,\"sex\":1,\"city\":\"Yoshkar-Ola\",\"state\":\"\",\"country\":\"Russia\",\"registration_date\":\"2011-12-11T10:16:34-05:00\",\"about\":\"\",\"domain\":\"TheGoncharov.500px.com\",\"fotomoto_on\":true,\"locale\":\"en\",\"show_nude\":true,\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0,\"store_on\":true,\"contacts\":{\"facebook\":\"100002390537457\",\"twitter\":\"goncharov_s\",\"googleplus\":\"plus.google.com/u/0/113705973204492373290\",\"website\":\"thegoncharov.org\"},\"equipment\":{\"camera\":[\"Sony DSC-H50\"]},\"photos_count\":3,\"affection\":62,\"in_favorites_count\":17,\"friends_count\":28,\"followers_count\":7}}";
    private static final String PHOTOS_TEST_1 = "{\"feature\":\"editors\",\"filters\":{\"category\":false,\"exclude\":false},\"current_page\":1,\"total_pages\":218,\"total_items\":4355,\"photos\":[{\"id\":8532411,\"name\":\"Catch me if you can!\",\"description\":\"Please also check out my stories to see original images before post production:\\r\\n<a href=\\\"http://500px.com/roliketto/stories/40245/before-after\\\">500px.com/roliketto/stories/40245/before-after</a>\\r\\n\\r\\nThis is the third version of the same Varsity stadium, Toronto, Ontario, Canada. \\r\\nI hope you enjoy reviewing it as much as I enjoyed while I was working on this composition...\\r\\n\\r\\n\",\"times_viewed\":5990,\"rating\":79.2,\"created_at\":\"2012-06-13T07:09:22-04:00\",\"category\":24,\"privacy\":false,\"width\":5616,\"height\":3744,\"votes_count\":341,\"favorites_count\":164,\"comments_count\":138,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8532411/ac584e6bc9dfbbaaa373b166ccd7df969a0b1632/2.jpg\",\"user\":{\"id\":123478,\"username\":\"roliketto\",\"firstname\":\"Roland\",\"lastname\":\"Shainidze\",\"city\":\"Toronto\",\"country\":\"Canada\",\"fullname\":\"Roland Shainidze\",\"userpic_url\":\"http://acdn.500px.net/123478/39a91b71f955a84bdf82b71ad706f3c5096748cc/1.jpg?127\",\"upgrade_status\":2}},{\"id\":8537337,\"name\":\"Blue mountain light\",\"description\":\"Moon light photography S\\u00e4ntis Switzerland.\",\"times_viewed\":6090,\"rating\":79.6,\"created_at\":\"2012-06-13T10:57:38-04:00\",\"category\":8,\"privacy\":false,\"width\":1200,\"height\":800,\"votes_count\":496,\"favorites_count\":299,\"comments_count\":168,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8537337/d15a2c36b2e9bef5f926acb59bf03eeea1f0ef2a/2.jpg\",\"user\":{\"id\":151340,\"username\":\"kaiboehm\",\"firstname\":\"Kai\",\"lastname\":\"B\\u00f6hm\",\"city\":\"Bonn\",\"country\":\"Germany\",\"fullname\":\"Kai B\\u00f6hm\",\"userpic_url\":\"http://acdn.500px.net/151340/ce89f4d21f0709a6afc67febffd53107526345a2/1.jpg?0\",\"upgrade_status\":2}},{\"id\":8536863,\"name\":\"\\u041e\\u043b\\u0435\\u0441\\u044f\",\"description\":\"\",\"times_viewed\":5280,\"rating\":79.6,\"created_at\":\"2012-06-13T10:37:54-04:00\",\"category\":5,\"privacy\":false,\"width\":900,\"height\":600,\"votes_count\":621,\"favorites_count\":387,\"comments_count\":161,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8536863/894db6705b060625740c0f9b76b591e1c9f58b28/2.jpg\",\"user\":{\"id\":9128,\"username\":\"klad\",\"firstname\":\"Silaev\",\"lastname\":\"Konstantin\",\"city\":\"Moscow\",\"country\":\"Russia\",\"fullname\":\"Silaev Konstantin\",\"userpic_url\":\"http://acdn.500px.net/9128.jpg\",\"upgrade_status\":0}},{\"id\":8538137,\"name\":\"perspective\",\"description\":\"\",\"times_viewed\":6666,\"rating\":79.8,\"created_at\":\"2012-06-13T11:36:59-04:00\",\"category\":9,\"privacy\":false,\"width\":900,\"height\":600,\"votes_count\":1356,\"favorites_count\":784,\"comments_count\":434,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8538137/034ae896d053537c4bc60f7f6311f1bc4899e4f7/2.jpg\",\"user\":{\"id\":695797,\"username\":\"Adam_Dobrovits\",\"firstname\":\"Adam\",\"lastname\":\"Dobrovits\",\"city\":\"\",\"country\":\"\",\"fullname\":\"Adam Dobrovits\",\"userpic_url\":\"http://acdn.500px.net/695797/4c3dd2e8ac56a08f069ab35aa022d5da5a1fecc5/1.jpg?127\",\"upgrade_status\":0}},{\"id\":8528702,\"name\":\"Tears of heaven\",\"description\":\"A women's monastery, Moscow region\",\"times_viewed\":5347,\"rating\":78.9,\"created_at\":\"2012-06-13T03:31:25-04:00\",\"category\":8,\"privacy\":false,\"width\":1155,\"height\":839,\"votes_count\":356,\"favorites_count\":190,\"comments_count\":145,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8528702/f3fcc7b6e237fc2d476b6bc2ef6b5183268334df/2.jpg\",\"user\":{\"id\":83363,\"username\":\"Luiza_Gelts\",\"firstname\":\"Luiza  Gelts -           \",\"lastname\":\"\\u041b\\u0443\\u0438\\u0437\\u0430  \\u0413\\u0435\\u043b\\u044c\\u0442\\u0441\",\"city\":\"Moscow - Dubna\",\"country\":\"Russia\",\"fullname\":\"Luiza  Gelts -            \\u041b\\u0443\\u0438\\u0437\\u0430  \\u0413\\u0435\\u043b\\u044c\\u0442\\u0441\",\"userpic_url\":\"http://acdn.500px.net/83363/3f301ec26eb9488dc6396e041ee98f81392db0d8/1.jpg?127\",\"upgrade_status\":0}},{\"id\":8532808,\"name\":\"POPCORN EXPLOSION 2\",\"description\":\"\",\"times_viewed\":1835,\"rating\":79.5,\"created_at\":\"2012-06-13T07:32:11-04:00\",\"category\":6,\"privacy\":false,\"width\":850,\"height\":567,\"votes_count\":147,\"favorites_count\":79,\"comments_count\":49,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8532808/6f24a5d7aa1221fc02d3e8ec9a4766fea2b2367c/2.jpg\",\"user\":{\"id\":216482,\"username\":\"Manuelcafini\",\"firstname\":\"Manuel \",\"lastname\":\"Cafini\",\"city\":\"civitanova marche\",\"country\":\"\",\"fullname\":\"Manuel  Cafini\",\"userpic_url\":\"http://acdn.500px.net/216482/2d88fde284293aabf4064939aae8680d6fe98794/1.jpg?109\",\"upgrade_status\":0}},{\"id\":8350702,\"name\":\"Pouring Rain\",\"description\":\"\",\"times_viewed\":5176,\"rating\":74.7,\"created_at\":\"2012-06-07T05:40:52-04:00\",\"category\":10,\"privacy\":false,\"width\":5476,\"height\":3651,\"votes_count\":320,\"favorites_count\":183,\"comments_count\":64,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8350702/0e6db32d4ef0c5968c8a3eff595fdc1ce73e3d60/2.jpg\",\"user\":{\"id\":329570,\"username\":\"SimonBerger\",\"firstname\":\"Simon\",\"lastname\":\"Berger\",\"city\":\"Ravensburg\",\"country\":\"Germany\",\"fullname\":\"Simon Berger\",\"userpic_url\":\"/graphics/userpic.png\",\"upgrade_status\":0}},{\"id\":8355083,\"name\":\"Join us for a drink (part III)\",\"description\":\"It was a gray and rainy day, when I visited this charming little chateau. Once I entered the building I thought this was going to be one of those short, not very memorable shoots, but as it turned out this location had more to offer.\",\"times_viewed\":2028,\"rating\":74.6,\"created_at\":\"2012-06-07T09:07:11-04:00\",\"category\":27,\"privacy\":false,\"width\":5197,\"height\":5197,\"votes_count\":242,\"favorites_count\":133,\"comments_count\":96,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8355083/3c412db750a10b208b952dcc96a67bb79d6d82b6/2.jpg\",\"user\":{\"id\":661138,\"username\":\"Remy_Frints\",\"firstname\":\"Remy\",\"lastname\":\"Frints\",\"city\":\"Maastricht\",\"country\":\"The Netherlands\",\"fullname\":\"Remy Frints\",\"userpic_url\":\"http://acdn.500px.net/661138/76a77846ad3e43b476ff219e55864fbfec2e0d10/1.jpg?127\",\"upgrade_status\":0}},{\"id\":8363964,\"name\":\"Sisters\",\"description\":\"\",\"times_viewed\":2446,\"rating\":74.6,\"created_at\":\"2012-06-07T14:47:47-04:00\",\"category\":19,\"privacy\":false,\"width\":1280,\"height\":850,\"votes_count\":252,\"favorites_count\":163,\"comments_count\":75,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8363964/da61731499dc670f51da8c0a8ea02d5ceb6b19ee/2.jpg\",\"user\":{\"id\":115021,\"username\":\"maurizioraffa\",\"firstname\":\"maurizio\",\"lastname\":\"raffa\",\"city\":\"Bergamo\",\"country\":\"Italy\",\"fullname\":\"maurizio raffa\",\"userpic_url\":\"http://acdn.500px.net/115021.jpg\",\"upgrade_status\":0}},{\"id\":8364380,\"name\":\"Bombyx mori\",\"description\":\"\",\"times_viewed\":2796,\"rating\":74.7,\"created_at\":\"2012-06-07T15:00:31-04:00\",\"category\":12,\"privacy\":false,\"width\":800,\"height\":533,\"votes_count\":198,\"favorites_count\":89,\"comments_count\":70,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8364380/ffbcbc85a662f424b12a48869439448d9eacc956/2.jpg\",\"user\":{\"id\":831371,\"username\":\"torckmacros\",\"firstname\":\"Paulo\",\"lastname\":\"Torck\",\"city\":\"Parede\",\"country\":\"Portugal\",\"fullname\":\"Paulo Torck\",\"userpic_url\":\"http://acdn.500px.net/831371/ff06699503ac1e060659a3114b4148e7e4f45410/1.jpg?127\",\"upgrade_status\":0}},{\"id\":8361584,\"name\":\"Early Cast\",\"description\":\"\",\"times_viewed\":1783,\"rating\":74.6,\"created_at\":\"2012-06-07T13:24:54-04:00\",\"category\":6,\"privacy\":false,\"width\":1716,\"height\":1130,\"votes_count\":149,\"favorites_count\":94,\"comments_count\":45,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8361584/0b25b71ce9f3f785f0de662d5729049449c3c775/2.jpg\",\"user\":{\"id\":887974,\"username\":\"noelubaldo\",\"firstname\":\"noel\",\"lastname\":\"ubaldo\",\"city\":\"Pangasinan\",\"country\":\"Philippines\",\"fullname\":\"noel ubaldo\",\"userpic_url\":\"http://acdn.500px.net/887974/b4e3af8641467eef75bf276d4fe1cf80677ba625/1.jpg?127\",\"upgrade_status\":2}},{\"id\":8363698,\"name\":\"Crossing the Alps\",\"description\":\"This picture was taken during a hot-air balloon ride across the alps. We took off in Germany (near Rosenheim) and touched down in Italy with a very nice view of Venice. \",\"times_viewed\":2331,\"rating\":74.9,\"created_at\":\"2012-06-07T14:37:32-04:00\",\"category\":8,\"privacy\":false,\"width\":3018,\"height\":2012,\"votes_count\":331,\"favorites_count\":237,\"comments_count\":94,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8363698/ee1a244a603def919e51e895da491801a096075b/2.jpg\",\"user\":{\"id\":41164,\"username\":\"olli_muc\",\"firstname\":\"Olli\",\"lastname\":\"H.\",\"city\":\"Munich\",\"country\":\"Germany\",\"fullname\":\"Olli H.\",\"userpic_url\":\"http://acdn.500px.net/41164/449517cdd3810e7e300e096b61e2d6cd2ff8da3e/1.jpg?41\",\"upgrade_status\":1}},{\"id\":8363467,\"name\":\"Genesis\",\"description\":\"\",\"times_viewed\":6483,\"rating\":74.9,\"created_at\":\"2012-06-07T14:31:02-04:00\",\"category\":0,\"privacy\":false,\"width\":800,\"height\":800,\"votes_count\":608,\"favorites_count\":370,\"comments_count\":177,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8363467/d20711ddfb427bbd568a9def98344a2913221755/2.jpg\",\"user\":{\"id\":359383,\"username\":\"MarcoBarchesi\",\"firstname\":\"Marco\",\"lastname\":\"Barchesi\",\"city\":\"\",\"country\":\"Bergamo\",\"fullname\":\"Marco Barchesi\",\"userpic_url\":\"http://acdn.500px.net/359383.jpg\",\"upgrade_status\":0}},{\"id\":8361334,\"name\":\"London #07: Tower Bridge\",\"description\":\"\",\"times_viewed\":3551,\"rating\":74.8,\"created_at\":\"2012-06-07T13:15:08-04:00\",\"category\":9,\"privacy\":false,\"width\":800,\"height\":533,\"votes_count\":397,\"favorites_count\":229,\"comments_count\":130,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8361334/297b8c86ed7145f9e7a7e4b9637cbfca4714a4cf/2.jpg\",\"user\":{\"id\":58875,\"username\":\"NinaPapiorek\",\"firstname\":\"Nina\",\"lastname\":\"Papiorek\",\"city\":\"Oberhausen\",\"country\":\"Germany\",\"fullname\":\"Nina Papiorek\",\"userpic_url\":\"http://acdn.500px.net/58875.jpg\",\"upgrade_status\":0}},{\"id\":8357740,\"name\":\"***\",\"description\":\"fotopara.ru \\r\\nfotopara.livejournal.com\",\"times_viewed\":7875,\"rating\":74.6,\"created_at\":\"2012-06-07T11:02:05-04:00\",\"category\":7,\"privacy\":false,\"width\":900,\"height\":615,\"votes_count\":243,\"favorites_count\":159,\"comments_count\":46,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8357740/ea7f859afd2874e335947d067e004439ebbdb71b/2.jpg\",\"user\":{\"id\":30411,\"username\":\"fotopara\",\"firstname\":\"Viktor (fotopara)\",\"lastname\":\"Skorobogatov\",\"city\":\"\\u041c\\u043e\\u0441\\u043a\\u0432\\u0430\",\"country\":\"\\u0420\\u043e\\u0441\\u0441\\u0438\\u044f\",\"fullname\":\"Viktor (fotopara) Skorobogatov\",\"userpic_url\":\"http://acdn.500px.net/30411.jpg\",\"upgrade_status\":0}},{\"id\":8357866,\"name\":\"Untitled\",\"description\":\"\",\"times_viewed\":2079,\"rating\":74.7,\"created_at\":\"2012-06-07T11:08:21-04:00\",\"category\":21,\"privacy\":false,\"width\":1024,\"height\":683,\"votes_count\":175,\"favorites_count\":111,\"comments_count\":50,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8357866/eba1651a35110428e533a8affdaa692f90fbc1e5/2.jpg\",\"user\":{\"id\":224376,\"username\":\"RogerBoon\",\"firstname\":\"\",\"lastname\":\"\",\"city\":\"\",\"country\":\"Singapore\",\"fullname\":\"RogerBoon\",\"userpic_url\":\"http://acdn.500px.net/224376/89806b7bd1864f69abfb208314eaac5ece5a7eee/1.jpg?127\",\"upgrade_status\":0}},{\"id\":8357733,\"name\":\"Light Olympic Painting\",\"description\":\"\",\"times_viewed\":3893,\"rating\":74.4,\"created_at\":\"2012-06-07T11:01:57-04:00\",\"category\":17,\"privacy\":false,\"width\":800,\"height\":533,\"votes_count\":209,\"favorites_count\":96,\"comments_count\":59,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8357733/72563498c9d282b3d73d68c9a5ba6c0f0d963d6b/2.jpg\",\"user\":{\"id\":398493,\"username\":\"MarcosFerroPhoto\",\"firstname\":\"Marcos\",\"lastname\":\"Ferro\",\"city\":\"Ciudad de M\\u00e9xico\",\"country\":\"Argentina/Mexico\",\"fullname\":\"Marcos Ferro\",\"userpic_url\":\"http://acdn.500px.net/398493/a18242be78c84eb1aa1cd937af7e0a2d60de9159/1.jpg?0\",\"upgrade_status\":0}},{\"id\":8354340,\"name\":\"face to face\",\"description\":\"\",\"times_viewed\":5008,\"rating\":74.9,\"created_at\":\"2012-06-07T08:35:39-04:00\",\"category\":12,\"privacy\":false,\"width\":900,\"height\":603,\"votes_count\":698,\"favorites_count\":391,\"comments_count\":252,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8354340/af29647b28a90e9cb4212bf9fe108eb1f81e9a8c/2.jpg\",\"user\":{\"id\":214638,\"username\":\"nordinseruyan\",\"firstname\":\"nordin\",\"lastname\":\"seruyan\",\"city\":\"indonesia\",\"country\":\"seruyan\",\"fullname\":\"nordin seruyan\",\"userpic_url\":\"http://acdn.500px.net/214638.jpg\",\"upgrade_status\":0}},{\"id\":8353048,\"name\":\"#05 - won't get fooled again\",\"description\":\"more of these on www.facebook.com/nadir.project\",\"times_viewed\":6451,\"rating\":74.5,\"created_at\":\"2012-06-07T07:43:44-04:00\",\"category\":7,\"privacy\":false,\"width\":1417,\"height\":876,\"votes_count\":482,\"favorites_count\":240,\"comments_count\":115,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8353048/f5611e0b498bf98c8aff6029c954925933821424/2.jpg\",\"user\":{\"id\":887411,\"username\":\"jensunglaube\",\"firstname\":\"nadir's big chance\",\"lastname\":\"(project)\",\"city\":\"Bonn\",\"country\":\"Germany\",\"fullname\":\"nadir's big chance (project)\",\"userpic_url\":\"http://acdn.500px.net/887411/85195fb71c6c0412f5f07ce619310fd7de86b39c/1.jpg?19\",\"upgrade_status\":2}},{\"id\":8359858,\"name\":\"Domestic Chaos\",\"description\":\"\\\"Chaos is a friend of mine\\\" \\u2013 Bob Dylan\\r\\n\\r\\nCarly & Mike's engagement, co-starring their son Griffin and dog Tully. Shot on location in their home!\\r\\n\\r\\n<a href=\\\"http://www.facebook.com/shawns365\\\">More on Facebook!</a> \",\"times_viewed\":3605,\"rating\":74.8,\"created_at\":\"2012-06-07T12:24:13-04:00\",\"category\":24,\"privacy\":false,\"width\":1200,\"height\":1800,\"votes_count\":423,\"favorites_count\":290,\"comments_count\":80,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8359858/023765f0515ab104d18111bd9b2059b9417da8f9/2.jpg\",\"user\":{\"id\":728093,\"username\":\"shawnvandaele\",\"firstname\":\"Shawn\",\"lastname\":\"Van Daele\",\"city\":\"Eden Mills\",\"country\":\"Canada\",\"fullname\":\"Shawn Van Daele\",\"userpic_url\":\"http://acdn.500px.net/728093/3d87d1f0bd62601b58cec0b79000fc0fcdeec599/1.jpg?78\",\"upgrade_status\":1}}]}";
    private static final String PHOTOS_TEST_2 = "{\"feature\":\"user\",\"filters\":{\"category\":false,\"exclude\":false,\"user_id\":454167},\"current_page\":1,\"total_pages\":1,\"total_items\":3,\"photos\":[{\"id\":8328712,\"name\":\"Yoshkar-Ola\",\"description\":\"\",\"times_viewed\":55,\"rating\":67.5,\"created_at\":\"2012-06-06T11:02:23-04:00\",\"category\":9,\"privacy\":false,\"width\":3452,\"height\":2586,\"votes_count\":12,\"favorites_count\":4,\"comments_count\":13,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/8328712/1b78c16149a50e4c96031fca518e667e4a1e3dfe/2.jpg\",\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"city\":\"Yoshkar-Ola\",\"country\":\"Russia\",\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0}},{\"id\":7875059,\"name\":\"Yoshkar-Ola\",\"description\":\"\",\"times_viewed\":165,\"rating\":71.6,\"created_at\":\"2012-05-23T11:59:16-04:00\",\"category\":9,\"privacy\":false,\"width\":4709,\"height\":2330,\"votes_count\":37,\"favorites_count\":6,\"comments_count\":39,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/7875059/f9b2a6164fb280dab8c734edc9ef170b6c6e6d5f/2.jpg\",\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"city\":\"Yoshkar-Ola\",\"country\":\"Russia\",\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0}},{\"id\":6185604,\"name\":\"Yoshkar-Ola\",\"description\":\"\",\"times_viewed\":156,\"rating\":46.4,\"created_at\":\"2012-03-30T15:24:27-04:00\",\"category\":9,\"privacy\":false,\"width\":3453,\"height\":2584,\"votes_count\":13,\"favorites_count\":7,\"comments_count\":13,\"nsfw\":false,\"image_url\":\"http://pcdn.500px.net/6185604/bc567eed818eb35e28b3f385cbc9ea86a5fa2bd1/2.jpg\",\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"city\":\"Yoshkar-Ola\",\"country\":\"Russia\",\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0}}]}";
    private static final String PHOTO_SHOW_TEST_1 = "{\"photo\":{\"id\":8328712,\"user_id\":454167,\"name\":\"Yoshkar-Ola\",\"description\":\"\",\"camera\":\"DSC-H50\",\"lens\":\"\",\"focal_length\":\"5.2\",\"iso\":\"100\",\"shutter_speed\":\"0.0125\",\"aperture\":\"4\",\"times_viewed\":55,\"rating\":67.5,\"status\":1,\"created_at\":\"2012-06-06T11:02:23-04:00\",\"category\":9,\"location\":null,\"privacy\":false,\"latitude\":null,\"longitude\":null,\"taken_at\":\"2012-05-08T19:46:06-04:00\",\"hi_res_uploaded\":1,\"for_sale\":true,\"width\":3452,\"height\":2586,\"votes_count\":12,\"favorites_count\":4,\"comments_count\":13,\"nsfw\":false,\"sales_count\":0,\"for_sale_date\":null,\"highest_rating\":74.7,\"highest_rating_date\":\"2012-06-07T06:55:13-04:00\",\"image_url\":\"http://pcdn.500px.net/8328712/1b78c16149a50e4c96031fca518e667e4a1e3dfe/4.jpg\",\"store_download\":true,\"store_print\":true,\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"city\":\"Yoshkar-Ola\",\"country\":\"Russia\",\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0}},\"comments\":[]}";
    private static final String PHOTO_SHOW_COMMENTS_TEST_1 = "{\"photo\":{\"id\":8328712,\"user_id\":454167,\"name\":\"Yoshkar-Ola\",\"description\":\"\",\"camera\":\"DSC-H50\",\"lens\":\"\",\"focal_length\":\"5.2\",\"iso\":\"100\",\"shutter_speed\":\"0.0125\",\"aperture\":\"4\",\"times_viewed\":55,\"rating\":67.5,\"status\":1,\"created_at\":\"2012-06-06T11:02:23-04:00\",\"category\":9,\"location\":null,\"privacy\":false,\"latitude\":null,\"longitude\":null,\"taken_at\":\"2012-05-08T19:46:06-04:00\",\"hi_res_uploaded\":1,\"for_sale\":true,\"width\":3452,\"height\":2586,\"votes_count\":12,\"favorites_count\":4,\"comments_count\":13,\"nsfw\":false,\"sales_count\":0,\"for_sale_date\":null,\"highest_rating\":74.7,\"highest_rating_date\":\"2012-06-07T06:55:13-04:00\",\"image_url\":\"http://pcdn.500px.net/8328712/1b78c16149a50e4c96031fca518e667e4a1e3dfe/4.jpg\",\"store_download\":true,\"store_print\":true,\"user\":{\"id\":454167,\"username\":\"TheGoncharov\",\"firstname\":\"Stanislav\",\"lastname\":\"Goncharov\",\"city\":\"Yoshkar-Ola\",\"country\":\"Russia\",\"fullname\":\"Stanislav Goncharov\",\"userpic_url\":\"http://acdn.500px.net/454167/b3b3eb7a38955c6796019b48d05516b29e01fc0c/1.jpg?127\",\"upgrade_status\":0}},\"comments\":[{\"id\":18044877,\"user_id\":575844,\"to_whom_user_id\":454167,\"body\":\"wow nice composition\",\"created_at\":\"2012-06-15T06:03:06-04:00\",\"parent_id\":null,\"user\":{\"id\":575844,\"username\":\"awdpnb\",\"firstname\":\"Arief\",\"lastname\":\"Wardhana\",\"fullname\":\"Arief Wardhana\",\"userpic_url\":\"http://acdn.500px.net/575844/a1d5347026f3c94814f111dede65c474acc95e14/1.jpg?97\",\"upgrade_status\":1}},{\"id\":18024527,\"user_id\":239856,\"to_whom_user_id\":454167,\"body\":\"Great POV...\",\"created_at\":\"2012-06-14T22:24:22-04:00\",\"parent_id\":null,\"user\":{\"id\":239856,\"username\":\"SharonKavanagh\",\"firstname\":\"Sharon\",\"lastname\":\"Kavanagh\",\"fullname\":\"Sharon Kavanagh\",\"userpic_url\":\"http://acdn.500px.net/239856.jpg\",\"upgrade_status\":2}},{\"id\":17635820,\"user_id\":563872,\"to_whom_user_id\":454167,\"body\":\"Powerful image!  Voted!    \",\"created_at\":\"2012-06-10T14:29:52-04:00\",\"parent_id\":null,\"user\":{\"id\":563872,\"username\":\"JeffScozzafava\",\"firstname\":\"Jeff\",\"lastname\":\"Scozzafava\",\"fullname\":\"Jeff Scozzafava\",\"userpic_url\":\"http://acdn.500px.net/563872/286492ca3740294db02a5131a8af1b5db76e28fa/1.jpg?68\",\"upgrade_status\":0}},{\"id\":17592401,\"user_id\":583812,\"to_whom_user_id\":454167,\"body\":\"excellent shot !\",\"created_at\":\"2012-06-10T06:04:56-04:00\",\"parent_id\":null,\"user\":{\"id\":583812,\"username\":\"vikkor\",\"firstname\":\"Viktor\",\"lastname\":\"Korostynski\",\"fullname\":\"Viktor Korostynski\",\"userpic_url\":\"http://acdn.500px.net/583812/8b6a3a092664cf5cf429dbc8a8673e5df0ef39b9/1.jpg?54\",\"upgrade_status\":0}},{\"id\":17556606,\"user_id\":154067,\"to_whom_user_id\":454167,\"body\":\"excellent shot!!!!v&f\",\"created_at\":\"2012-06-09T15:54:40-04:00\",\"parent_id\":null,\"user\":{\"id\":154067,\"username\":\"aijems\",\"firstname\":\"anthony\",\"lastname\":\"mejia\",\"fullname\":\"anthony mejia\",\"userpic_url\":\"http://acdn.500px.net/154067/49f9d0a811dc0fd7f722ec2bae6840c37038032b/1.jpg?122\",\"upgrade_status\":2}},{\"id\":17556370,\"user_id\":563732,\"to_whom_user_id\":454167,\"body\":\"great  shot!!beautiful processing!\",\"created_at\":\"2012-06-09T15:51:18-04:00\",\"parent_id\":null,\"user\":{\"id\":563732,\"username\":\"ItamarCampos\",\"firstname\":\"Itamar\",\"lastname\":\"Campos\",\"fullname\":\"Itamar Campos\",\"userpic_url\":\"http://acdn.500px.net/563732/40ae7466f9a31ae5388382ba85679ab8638ce162/1.jpg?28\",\"upgrade_status\":0}},{\"id\":17374579,\"user_id\":558552,\"to_whom_user_id\":454167,\"body\":\"Wow! Great photo...well done!\",\"created_at\":\"2012-06-07T14:21:38-04:00\",\"parent_id\":null,\"user\":{\"id\":558552,\"username\":\"Daniel_Bosma\",\"firstname\":\"Daniel\",\"lastname\":\"Bosma\",\"fullname\":\"Daniel Bosma\",\"userpic_url\":\"http://acdn.500px.net/558552/9007a94276ee148923f355f4b292c07e6474823a/1.jpg?127\",\"upgrade_status\":2}},{\"id\":17336557,\"user_id\":811620,\"to_whom_user_id\":454167,\"body\":\"Awesome!\",\"created_at\":\"2012-06-07T06:55:15-04:00\",\"parent_id\":null,\"user\":{\"id\":811620,\"username\":\"Siciliamia\",\"firstname\":\"Alice\",\"lastname\":\"T.\",\"fullname\":\"Alice T.\",\"userpic_url\":\"http://acdn.500px.net/811620/74a8268f9d4a95b0215f3ee58fec24d818cf065e/1.jpg?127\",\"upgrade_status\":0}},{\"id\":17286095,\"user_id\":23735,\"to_whom_user_id\":454167,\"body\":\"Well done ++\",\"created_at\":\"2012-06-06T14:27:08-04:00\",\"parent_id\":null,\"user\":{\"id\":23735,\"username\":\"soli\",\"firstname\":\"Soli\",\"lastname\":\"Art\",\"fullname\":\"Soli Art\",\"userpic_url\":\"http://acdn.500px.net/23735/3cb4d94998e3a4d7c91c8f275d90b607cf58ef91/1.jpg?93\",\"upgrade_status\":0}},{\"id\":17271367,\"user_id\":145138,\"to_whom_user_id\":454167,\"body\":\"Wonderful!\",\"created_at\":\"2012-06-06T11:46:12-04:00\",\"parent_id\":null,\"user\":{\"id\":145138,\"username\":\"nageshm\",\"firstname\":\"Nagesh\",\"lastname\":\"Mahadev\",\"fullname\":\"Nagesh Mahadev\",\"userpic_url\":\"http://acdn.500px.net/145138/5b06302fc42a9342274db2b77e5afe687ee928d3/1.jpg?39\",\"upgrade_status\":0}},{\"id\":17271292,\"user_id\":417809,\"to_whom_user_id\":454167,\"body\":\"Great POV!!!\",\"created_at\":\"2012-06-06T11:45:26-04:00\",\"parent_id\":null,\"user\":{\"id\":417809,\"username\":\"mattei\",\"firstname\":\"Romain Matte\\u00ef\",\"lastname\":\"Photography\",\"fullname\":\"Romain Matte\\u00ef Photography\",\"userpic_url\":\"http://acdn.500px.net/417809/faf434ce3c3b6040d909a12b36ecc2cbd32c8ae5/1.jpg?70\",\"upgrade_status\":2}},{\"id\":17271156,\"user_id\":734817,\"to_whom_user_id\":454167,\"body\":\"great pov!\",\"created_at\":\"2012-06-06T11:43:58-04:00\",\"parent_id\":null,\"user\":{\"id\":734817,\"username\":\"Ashira\",\"firstname\":\"Stefania\",\"lastname\":\"Gasparri\",\"fullname\":\"Stefania Gasparri\",\"userpic_url\":\"http://acdn.500px.net/734817/f05cfe6cea4e7beed47761f1cb561e8002573305/1.jpg?127\",\"upgrade_status\":0}},{\"id\":17269288,\"user_id\":490463,\"to_whom_user_id\":454167,\"body\":\"Very good work!\",\"created_at\":\"2012-06-06T11:21:35-04:00\",\"parent_id\":null,\"user\":{\"id\":490463,\"username\":\"mirek\",\"firstname\":\"Mirek\",\"lastname\":\" .\",\"fullname\":\"Mirek  .\",\"userpic_url\":\"http://acdn.500px.net/490463/e99a795a658b73c6f1aee05253c9695a95b4f04f/1.jpg?0\",\"upgrade_status\":0}}]}";

    @Override
    protected void setUp() throws Exception {
        mapper = new JsonOrgMapper();
    }

    public void testUserProfileParseEntity() {
        UserProfile user = mapper.parseEntity(USER_TEST_1, UserProfile.class);
        System.out.println(user);
        assertNotNull(user);
        assertEquals(user.getId(), 454167);
        assertEquals(user.getBirthday(), null);
        //assertEquals(Sex.MALE, user.getSex());
        assertEquals(Locale.EN, user.getLocale());
        assertNotNull(user.getRegistrationDate());
        UserProfile.UserContacts contacts = user.getContacts();
        assertNotNull(contacts);
        assertNotNull(contacts.getGooglePlus());
        UserProfile.UserEquipment equipment = user.getEquipment();
        assertNotNull(equipment);
        assertNotNull(equipment.getCamera());
    }

    public void testPhotosParseEntity() {
        PhotoStream stream = mapper.parseEntity(PHOTOS_TEST_1, PhotoStream.class);
        assertNotNull(stream);
    }

    public void testPhotos2ParseEntity() {
        PhotoStream stream = mapper.parseEntity(PHOTOS_TEST_2, PhotoStream.class);
        assertNotNull(stream);
        assertEquals(3, stream.photos.length);
    }

    public void testPhotoWithComments() {
        PhotoResponse resp = mapper.parseEntity(PHOTO_SHOW_COMMENTS_TEST_1, PhotoResponse.class);
        assertNotNull(resp);
        assertEquals(13, resp.comments.length);
    }



}