package org.pcchen.pdmi.caiyun;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 内容库文章socket接口
 *
 * @author ceek
 * @create 2020-06-24 14:01
 **/
public class ContentArticleSocket {
    public static void main(String[] args) {
        String uarBaseContentCURLSocketIp = "10.10.32.79";
        String uarBaseContentCURLSocketPort = "2222";

//        System.out.println(new ContentArticleSocket().deleteByUrl("http://www.baidu.com/777711212121211234", uarBaseContentCURLSocketIp, uarBaseContentCURLSocketPort));
        System.out.println(new ContentArticleSocket().addContent(
                "4078",//mediaId
                "彩练新闻1",//source
                "测试",//columnName
                "https://www.hubpd.com/c/2020-07-09/966836.shtml",//url
                "Y",//original
                "2020-07-09 12:05:54",//publishTime
                "<p style=\\\"font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 18px; line-height: 1.75em; margin-bottom: 25px; margin-top: 25px; text-indent: 2em;\\\">近日，中国小康建设研究会党刊工作委员会在北京成立，将为促进传统媒体和新兴媒体融合发展，为各级党刊、企业期刊融合发展提供相应服务。同时发挥各级党刊联系广泛的优势，开展服务地方政府、服务全面建成小康社会的相关活动。</p ><p style=\\\"font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 18px; line-height: 1.75em; margin-bottom: 25px; margin-top: 25px; text-indent: 2em;\\\">据了解，中国小康建设研究会是由有志于促进我国小康建设的各界人士及社会团体、企事业单位自愿组成的全国性社会团体，于2008年7月4日正式成立。根据党中央全面建设小康社会的战略部署，中国小康建设研究会成立以来，依据国家宪法、法律、法规，围绕“研究发展问题，促进经验交流，提供政策依据，推进小康进程，服务中央决策”的发展宗旨，积极主动地开展调研、咨询、出版、宣传、服务等各项工作，为全面建成小康社会建言献策，进行专题研究探讨，总结实践经验，提出对策建议，为中央和地方党政及企业科学决策提供了重要参考。</p ><p style=\\\"font-family: 微软雅黑, &quot;Microsoft YaHei&quot;; font-size: 18px; line-height: 1.75em; margin-bottom: 25px; margin-top: 25px; text-indent: 2em;\\\">中国小康建设研究会党刊工作委员会负责人介绍，党刊是党的事业的重要组成部分，是党和人民的喉舌，是宣传党的方针政策的主阵地,是党和政府联系人民群众的桥梁和纽带，也是指导各项工作，交流工作经验的重要载体,更是各级党组织宣传教育广大党员干部,大力弘扬社会主义核心价值观、唱响主旋律、传递正能量的重要平台。中国小康建设研究会党刊工作委员会将充分发挥各级党刊联系地方党政领导和相关部门的优势，开展服务地方政府、服务全面建成小康社会战略的相关活动；在传统媒体与新兴媒体融合的进程中，通过挖掘、策划、整合、传播等系列工作， 积极拓展服务内容，承担社会责任，把工作落到实处，为全面建成小康社会，实现“两个一百年”奋斗目标和中华民族伟大复兴中国梦做出应有的贡献。（多丰）</p ><p><br/></p >",
                "中国小康建设研究会党刊工作委员会在京成立",//title
                "tangsi",//edit
                "",//keywords
                "",//author
                "",//copyright
                "近日，中国小康建设研究会党刊工作委员会在北京成立，将为促进传统媒体和新兴媒体融合发展，为各级党刊、企业期刊融合发展提供相应服务。",//describe
                "http://img.redocn.com/sheji/20141219/zhongguofengdaodeliyizhanbanzhijing_3744115.jpg",//cover
                "",//video
                "966836",//contentID
                uarBaseContentCURLSocketIp,
                uarBaseContentCURLSocketPort));
//        System.out.println(new ContentArticleSocket().updateContentByUrl(
////                "4078",
//                "4078",
////                "彩练新闻2",
//                "彩练新闻1",
////                "文体",
//                "文体测试",
//                "https://blog.csdn.net/zmj_88888888/article/details/8819105?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase%26depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase",
//                "Y",
//                "2020-05-17 13:10:58",
////                "2019-04-17 13:10:58",
//                "<div> <p class=\"txt\">人间烟火气，最抚百姓心。夏日时节，得益于中央释放的政策红利，伴随着新冠肺炎疫情防控形势持续向好，我国多个城市先后有序开放夜间经济。在玉溪中心城区，淘宝街带着熟悉的味道恢复了昔日的热闹，随着青花街、花涧里的先后开市，夜间经济点亮了这座城市夏日的夜晚，熙熙攘攘的街市充满了人间烟火气。</p> <p class=\"txt\">夜间经济蓬勃发展对于疫情后提振百姓生活信心、刺激消费、带动就业有着积极的作用。红塔区以“稳经济、促发展”为主题，通过市场运作和政策拉动，着力将“夜经济”打造成统筹推动疫情防控和经济社会发展的亮点工作。然而，在“夜经济”的打造过程中，如何规范管理、统筹规划，如何突出城市文化特色，提高城市配套管理水平，丰富多元的夜间经济业态也成为值得思考的命题。</p> <p class=\"txt\">抚慰人心的烟火气</p> <p class=\"txt\">烤鸡腿在炭火上旋转，冒油的烤串让人垂涎欲滴，红彤彤的爆炒小龙虾甚是诱人，还有那一个个色泽金黄、烧得鼓起的豆腐……在中心城区的淘宝街，空气中弥漫着诱人香气，行人熙熙攘攘，商贩卖力吆喝，人间烟火悄然而归。</p> <p class=\"txt\">“看一下嘛，水果捞，喜欢什么口味自己选择。”6月8日晚上8时许，27岁的吴友东一边麻利地为顾客打包，一边招揽着路过摊前的顾客，一旁的母亲代树香忙着找补零钱。</p> <p class=\"txt\"> </p> <p class=\"pic\"><img src=\"http://cb.uar.hubpd.com/spider_data/7c3f/7c3f411ff826ae775963b9d0843c88e6.jpg\"><br> </p> <p class=\"txt\"></p> <p class=\"txt\">吴友东和母亲靠这个摊位维持生活</p> <p class=\"txt\">在淘宝街有固定摊位的母子俩每晚准时出摊，有一份不错的收入，对此他们感到很满足，尤其是母亲代树香感受最深。</p> <p class=\"txt\">“我来玉溪十年了，以前是在南门街摆流动摊，每天会面临城管的驱赶，就像打游击一样。”回忆起以前摆摊的日子，代树香记忆犹新，“最尴尬的一次是刚把东西卖出去，看到城管来了，钱都没来得及收我就拎起东西跑了。”</p> <p class=\"txt\">自淘宝街开市后，代树香便在这里租下摊位，结束了流动摆摊的日子，由于生意不错，原本在昆明打工的儿子也回来帮忙，每天下午4点半出摊，晚上11点准时收摊。“现在每天能卖七八百元，多的时候上千元，比我在昆明打工强多了。”吴友东告诉记者。</p> <p class=\"txt\">在吴友东的旁边，蒋文波和龚玉琼夫妇正忙着售卖鲜花，夫妻俩在梁王坝种植了五亩花卉，主要销往昆明斗南，一些零散的鲜花他们会挑选来夜市售卖。“这里人比较多，每晚都能卖两三百元。”蒋文波说。对于蒋文波夫妇来说，每晚出摊的收入可以贴补家用。</p> <p class=\"txt\">“10元三双，随便挑，随便看。”不远处，来自河南的曹冰是最早入驻淘宝街的商贩，他在这里售卖袜子，这是他的副业。“虽然累些，但是能挣到钱。”曹冰说。</p> <p class=\"txt\"> </p> <p class=\"pic\"><img src=\"http://cb.uar.hubpd.com/spider_data/379d/379df6624158d6cf3494be49824b8931.jpg\"><br> </p> <p class=\"txt\"></p> <p class=\"txt\">曹冰在淘宝街售卖袜子，摆摊是他的副业。</p> <p class=\"txt\">在淘宝街，各色小吃让人垂涎，38岁的彭凯来自江西，看到淘宝街人气不错，2017年，他租下八个相连的摊位卖起海鲜，“这里人流量大，在这里经营的这几年收入还不错。”彭凯说。</p> <p class=\"txt\">“淘宝街”是市民们对位于红塔区彩虹商业广场夜市街的亲切称呼，2012年7月落地，作为探索城市管理的新尝试，经过多年运作，无论是街区商业结构，还是规范管理都已经相对成熟，目前是中心城区知名的夜市街区，现有摊位400余个，商铺300余间，带动3000人就业，平均每晚都有上万人次来这里消费。</p> <p class=\"txt\">临时民生街市的喜与忧</p> <p class=\"txt\">“疫情过后，民生为要”。伴随着政策的松绑，夜间经济开始兴盛，这也是对保就业、保市场经济、稳民生的最好诠释。</p> <p class=\"txt\">6月15日下午6点半，夕阳斜照大地，在清溪源（出水口）临时民生街市处，大学生肖远、韦智辉、蒋简三人支起了摊位开始售卖T恤衫，受疫情影响，在外上大学的他们还没有接到学校的开学通知，三人便协商来摆摊赚取生活费。“闲在家里也没事情做，我们商量后决定来这里摆摊体验生活，能自己赚到钱我们非常开心。”肖远告诉记者。</p> <p class=\"txt\">在停车位上停一辆车认好摊位，来自研和的女孩师娟在这里摆摊已经一个星期了，她身后的这辆车一直没有挪过。家里经营糕点生意，去年大学毕业的她一直在家帮忙，如今有了这个摆摊的机会，她晚上都会出摊，生意好的时候可以卖上千元，比在家里帮忙强多了。</p> <p class=\"txt\">在距离师娟摊位不远处，方磊和朋友们一起经营的卤味小吃卖得火爆，在短短一个小时内，200斤卤品全部售空，方磊脸上浮现出满足的笑容。</p> <p class=\"txt\">清溪源（出水口）临时民生街市汇聚各路摊主，从各种小吃到形形色色的小商品，所卖商品种类繁多。当然，这里也承载了不少人的创业梦，有在校大学生、公司白领、失业下岗工人等，一个地摊不仅解决了他们的就业，还圆了他们的增收梦。然而，伴随着街市的火爆，市场规范、环境卫生、交通拥堵等问题也随之出现。</p> <p class=\"txt\">“偶然路过这里，看到东风北路交通阻塞，我才发现这里有个夜市，并且人气很旺。”市民普娇说，“逛下来给我的感觉是人多商品多，但就是太乱了。”</p> <p class=\"txt\">“来这里给我最大的感觉就是杂乱无序，卖什么的都有，摊位品类多，人气比菜市场旺，但是却比菜市场更凌乱。”前来逛夜市的市民张磊与普娇有着同样的感受。</p> <p class=\"txt\">6月13日，聂耳文化广场服务中心发布《清溪源（出水口）临时民生街市文明规范经营告知书》（以下简称《告知书》），《告知书》上明确：不准售卖国家明令禁止的物品和假冒伪劣产品；不准售卖油炸、烧烤等有油烟污染的食品，确保油渍不污染路面等。此外，按照“先到先得”的原则摆摊经营，不准用帐篷、货架、凳子、石块等物品提前占用摊点。每天做到摊走地净，闭市期间未收走的物品，视为废弃物品，由临时民生街市管理人员统一处置。告知内容从6月14日起实施。</p> <p class=\"txt\">然而，尽管《告知书》已经发布，但是该临时民生街市的环境卫生等问题依然存在，摊走地净的现象并没出现。</p> <p class=\"txt\">6月22日一大早，在清溪源（出水口）临时民生街市，六七名保洁人员正努力清扫垃圾，她们告诉记者，现在每天早上6点开始清扫，要四个多小时才能基本清扫干净。“有些摊主会自己把垃圾收好，但是不少摊主还是把垃圾摆在那里。”保洁人员陆美仙告诉记者。</p> <p class=\"txt\">除了一地的垃圾，帐篷、货架、凳子、石块等提前占用摊点的物品依然摆放在此处。</p> <p class=\"txt\">城市烟火气的守护</p> <p class=\"txt\">夜间经济发展势头正劲，那么，在着力发展夜间经济的同时，如何在维护好城市生活环境的同时，保障城市烟火气持续升腾，成了考验城市管理者的问题。</p> <p class=\"txt\">在城市管理方面，红塔区城管局副局长李炜介绍：“在执法过程中我们坚持柔性执法与包容监管，比如说出店经营，有固定店铺的允许适度出店经营，要在保障不侵占盲道、不影响消防通道，不侵害他人利益等的前提下才允许出店经营。而对于轻微违法且及时整改的不予处罚，重点是对商家和摊贩进行教育指导。”</p> <p class=\"txt\">然而，在执法过程中，问题也不断凸显。李炜告诉记者，当下，中央释放政策红利，鼓励发展夜间经济，但不是让摊主们随意乱摆，尤其会对百姓生活造成影响的、阻碍通行秩序的地方是不让摆的。在摆的同时还要注重疫情防控、食品卫生安全。“一方面是放，但是放是在管的前提下放，不允许摆摊的地方还是不能摆，但是目前有些人对此有误解，也希望广大摊主们提高自觉意识。”李炜说。</p> <p class=\"txt\">而在市场监管方面，为保障夜间经济市场的安全，红塔区市场监督管理局积极开展夜间消费市场经营秩序、食品安全保障工作，引导经营者诚信经营，建立夜间诚信经营体系，营造良好的夜间经济发展环境，保障夜间经济繁荣发展。</p> <p class=\"txt\">据红塔区市场监督管理局副局长耿志坚介绍，区市场监管局在夜间市场监管方面以重点监管为补充、以信用监管为基础，对无证无照经营行为，属于违法行为轻微未造成严重危害后果的，采取包容性审慎监管，积极引导经营者办理相关证照即可。在夜间食品经营规范监管方面，则以经营资质、经营条件、从业人员管理、经营过程控制等要求为基本内容，督促夜间经济食品经营主体规范经营，实现夜间经济市场食品规范化经营。</p> <p class=\"txt\">目前，面对迅速发展的夜间经济，市场监管部门也面临新的挑战。“发展夜间经济，如果没有规划，摊位不相对固定，将加大相关部门的监管难度，因为夜间经济的发展、管理、服务涉及多部门职责。”耿志坚说。</p> <p class=\"txt\">在交通保障方面，记者从红塔交警大队了解到，为助力红塔区夜间经济发展，保障交通的顺利运行，在发展夜间经济的区域，对不影响正常道路通行的轻微交通违法行为以警告、引导为主；对辖区为农贸市场、夜市摊点等特殊路段、时段运输民生物资的三轮车，其轻微交通违法行为不处罚，以警告、教育为主，实现执法力度和温度兼顾，法律效果与社会效果融合。此外，结合交通安全管理需要，灵活采取限时禁停措施或限时停车措施，缓解经营户和购物者停车以及经营需求。协助完善周边停车指示标识，提供停车引导服务，盘活现有停车资源。</p> <p class=\"txt\">“在我看来，要让火爆的夜间经济保有持续的生命力，除了相关职能部门的监管外，更重要的还是得靠商户和市民的自觉。只有大家共同遵守城市管理规定，才能营造良好的夜市环境。”市民王燕说。</p> <p class=\"txt\">夜间经济发展的新探索</p> <p class=\"txt\">炎炎夏日，在拂面晚风清凉又温润的夜晚，如果你想邀上三五好友，喝啤酒、吃夜宵、逛夜市，告别一天的疲惫，在推杯换盏中享受城市的夜生活，那么选择青花街和花涧里定是不错的。而今，说起红塔区的夜间经济，人们都会想到青花街和花涧里，它们俨然成了中心城区夜间经济的新地标。</p> <p class=\"txt\"> </p> <p class=\"pic\"><img src=\"http://cb.uar.hubpd.com/spider_data/0ed2/0ed26d69f5892df232d03e973ce1fb58.jpg\"><br> </p> <p class=\"txt\"></p> <p class=\"txt\">青花街上花市灯如昼</p> <p class=\"txt\">3月28日，“玉溪青花夜宴”开宴，餐饮、花卉、文创产品等118家商户入驻青花街，集现代商业与文化旅游为一体，包含青花瓷工业遗存博物馆、陶艺大师工作室、陶瓷工艺体验、特色民宿精品酒店、地道玉溪米线与特色小吃、玉溪首家萌宠亲子动物园等商业、文旅等业态和元素。街区已实现开业运营300米，150户玉溪文创、非遗、餐饮商户入驻，青花夜宴日均客流达1.5万人次，日均营业收入为45万元，实现创业就业1000人，下一步将引进陶瓷企业、特色小吃等约285家入驻，打造一个不夜城的城市形象。</p> <p class=\"txt\">5月29日，云南醉美花鸟市场“花涧里”开市，花涧里以北市区花鸟市场为依托，利用原有的文化底蕴，结合现代人对美食美景、花艺茶艺的热爱，充分挖掘市场商户、手艺人的故事和技艺，打造具有文化传承的主题乐园，辐射带动花卉、茶叶、服务业、文化旅游业、商业购物等产业发展。</p> <p class=\"txt\">“我们的目标是打造云南省最漂亮的花鸟市场，接下来我们将进一步植入文化元素在这个项目里，这样才能有持续不断的生命力。”花涧里项目负责人王金富说。</p> <p class=\"txt\">无论是青花街还是花涧里，他们的开放为市民提供了夜间休闲的好去处，更帮助一部分人解决了生计问题。“我已经闲了大半年了，现在有这样好的条件来这里认了个摊位卖些卤味，每天还能有不错的收入，我觉得很知足。”花涧里的小吃摊主施孟沅告诉记者，现在工作难找，原来在工地打工的丈夫龙文福也没有事做，而今夫妻俩在花涧里摆摊。</p> <p class=\"txt\">据红塔区商务局副局长李明红介绍，红塔区立足区位和产业优势，重点培育餐饮、娱乐、旅游、休闲等适应市民夜间消费需求的新兴业态。以组织活动为载体，创新举措，搭建平台，不断营造夜间经济发展的良好社会氛围。目前，已经形成特色夜景区、特色夜美食、特色夜购物、特色夜娱乐等“四大夜色”。“特色夜景区”为“玉溪青花街”，“特色夜美食”为“汇龙星光广场”，“特色夜购物”为“玉溪淘宝街”，“特色夜娱乐”为“花涧里·云南醉美花鸟市场”。</p> <p class=\"txt\">“目前，红塔区打造夜间经济已具备较好的条件，有许多其他城市所不可比拟的优势，潜在消费需求增势强劲。2020年，以新天地、南北大街、水映溪里、高铁新城等为重点，精心打造高标准具有地标性的夜间经济消费街区，全面启动红塔区夜间经济消费街区的建设改造工作，今年至少启动1条夜间经济消费街区的提升打造工作，建成市民满意的夜间经济消费场所。启动夜间零售网点消费业态的培育和扶持，推进新天地、青花街第二期、鸿源美食广场二期建设。”李明红说。（ 玉溪日报全媒体记者  熊长青  文/图）</p> <p class=\"txt\">短    评</p> <p class=\"txt\">点亮城市夜色正逢时</p> <p class=\"txt\">□  初墨</p> <p class=\"txt\">夜间经济是现代城市经济的重要组成部分，做好夜间经济对繁荣夜间市场、提高生活质量、释放消费潜力、提高城市功能和品位有着十分重大的意义。悄然复苏的夜间经济让城市重新散发出久违的烟火气。时下，夜间经济发展势头正劲，打铁需趁热，发展夜间经济要抓住时机，利用热度乘势而上。</p> <p class=\"txt\">夜间经济是衡量一个城市人气的重要指标，城市管理者要多想招、多造点、多宣传、强管理。要因势利导，因地制宜，编制富有地方特色的夜间经济发展规划。科学评估辖区道路交通、居民生活出行情况，合理规划和设置一批集中摆摊经营区域，限时经营，规范市场经营秩序；对夜间经济重点区域、特色街区进行集中亮化美化，开展夜间灯光秀，做好街景打造，装饰照明，标识指引，提升夜间消费场所辩识度和吸引力，营造良好的消费氛围。</p> <p class=\"txt\">璀璨夜色与流光溢彩的背后，离不开监管与务实举措。相关部门要加强日常督导检查，遏制油烟污染环境或产生有害垃圾的露天烧烤餐饮等经营行为，确保经营场地卫生整洁和食品安全；对搭建临街违章建筑、超区域范围经营等行为要加强管理；优化交通组织管理，适当增加夜间经济街区周边临时停车位；优化夜间经济街区附近公共交通线路设置，加密夜间运行班次，适当延长公交车运营时间。</p> <p class=\"txt\">要充分利用好现有热度，持续激发夜间经济的消费潜力。植入地方文化元素，培育个性化、多元化消费形态，激发内在消费活力、挖掘夜间经济发展的巨大潜力；以夜间经济推动点，促进当地旅游业和服务业的发展；要不断对夜市街区进行调整升级，让热度延续下去，保持旺盛的生命力。</p> <p class=\"txt\">广大商户和摊主应提升自我修养。积极配合市场管理和城市管理部门工作，遵守市场秩序，文明经营，守法经营，有序有度开展经营，只有大家提升自我修养，共同遵守管理规定，方能营造良好的夜市环境，夜间经济也才能持续长久发展。</p> </div> <div> 编辑：刘燕    审核：马儒文 </div> <div></div>",
//                "测试title——12121211112",
//                "王小东",
//                "文都汇",
//                "吉林日报全媒体记者 龚保华",
//                "测试copuright——121212",
//                "今起报名！",
//                "http://img.redocn.com/sheji/20141219/zhongguofengdaodeliyizhanbanzhijing_3744115.jpg",
//                "",
//                "95967",
//                uarBaseContentCURLSocketIp,
//                uarBaseContentCURLSocketPort));
    }

    public String addContent(String mediaId, String source, String columnName, String url,
                             String original, String publishTime, String body, String title, String editer,
                             String keywords, String author, String copyright, String describe, String cover,
                             String video, String contentID, String uarBaseContentCURLSocketIp, String uarBaseContentCURLSocketPort) {
        //内容库入库的socket接口的ip
        JSONObject socketParam = new JSONObject();
        socketParam.put("request_method", "add_content");
        JSONObject sourceParam = new JSONObject();
        sourceParam.put("body", body);
        sourceParam.put("contentID", contentID);
        sourceParam.put("original", original);
        sourceParam.put("source", source);
        sourceParam.put("url", url);
        sourceParam.put("title", title);
        sourceParam.put("publishTime", publishTime);
        sourceParam.put("keywords", keywords);
        sourceParam.put("editer", editer);
        sourceParam.put("author", author);
        sourceParam.put("describe", describe);
        sourceParam.put("cover", cover);
        sourceParam.put("columnName", columnName);
        sourceParam.put("mediaId", mediaId);
        sourceParam.put("copyright", copyright);
        sourceParam.put("video", video);


        socketParam.put("_source", sourceParam);
        return this.socketRequest(uarBaseContentCURLSocketIp, Integer.parseInt(uarBaseContentCURLSocketPort), socketParam);
    }

    // uar--内容库内容删除根据url
    public String deleteByUrl(String url, String uarBaseContentCURLSocketIp, String uarBaseContentCURLSocketPort) {
        //内容库删改的socket接口的ip
        JSONObject socketParam = new JSONObject();
        socketParam.put("request_method", "deleteByUrl");
        socketParam.put("url", url);

        return this.socketRequest(uarBaseContentCURLSocketIp, Integer.parseInt(uarBaseContentCURLSocketPort), socketParam);
    }

    // uar--内容库内容根据url修改指定字段
    public String updateContentByUrl(String mediaId, String source, String columnName, String url,
                                     String original, String publishTime, String body, String title, String editer,
                                     String keywords, String author, String copyright, String describe, String cover,
                                     String video, String poster, String uarBaseContentCURLSocketIp, String uarBaseContentCURLSocketPort) {
        //内容库删改的socket接口的ip
        JSONObject socketParam = new JSONObject();
        socketParam.put("request_method", "updateContentByUrl");
        JSONObject sourceParam = new JSONObject();
        sourceParam.put("mediaId", mediaId);
        sourceParam.put("source", source);
        sourceParam.put("columnName", columnName);
        sourceParam.put("original", original);
        sourceParam.put("publishTime", publishTime);
        sourceParam.put("body", body);
//        sourceParam.put("title", title);
//        sourceParam.put("body", body);
//        sourceParam.put("editer", editer);
//        sourceParam.put("keywords", keywords);
//        sourceParam.put("author", author);
//        sourceParam.put("copyright", copyright);
//        sourceParam.put("describe", describe);
//        sourceParam.put("cover", cover);
//        sourceParam.put("video", video);
//        sourceParam.put("poster", poster);


        socketParam.put("_source", sourceParam);
        socketParam.put("url", url);

        return this.socketRequest(uarBaseContentCURLSocketIp, Integer.parseInt(uarBaseContentCURLSocketPort), socketParam);
    }

    private String socketRequest(String socketIp, Integer socketPort, JSONObject socketParam) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Socket client = null;
        OutputStream out = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        try {
            client = new Socket(socketIp, socketPort);
            out = client.getOutputStream();
            // 发送请求消息
            String sendStr = socketParam.toString() + "\n" + "exit" + "\n";
            out.write(sendStr.getBytes());
            out.flush();
            ir = new InputStreamReader(client.getInputStream(), "utf-8");

            br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
            String log = br.readLine();
            return log;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "1");
            resultMap.put("result", "请求失败请重试");
            return resultMap.toString();
        } finally {
            // 4.关闭资源
            if (ir != null) {
                try {
                    ir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
