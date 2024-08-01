package com.tenextractor.redefinablekeyboard.feature_config

import android.util.Log
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.domain.KeyWidth
import com.tenextractor.redefinablekeyboard.feature_config.domain.Layout
import com.tenextractor.redefinablekeyboard.feature_config.domain.SpecialKey

fun bottomRow(comma: String, space: String, period: String, bottomRowKey: Key? = null): List<Key> {
    return if (bottomRowKey != null) {
        listOf(
            Key(text = "", label = "⛭", width = KeyWidth.FractionWidth(.1F), specialKey = SpecialKey.CHANGELAYOUT),
            Key(comma, width = KeyWidth.FractionWidth(.1F)),
            bottomRowKey,
            Key(space, label = "␣", width = KeyWidth.FractionWidth(.25F)),
            Key("'", width = KeyWidth.FractionWidth(.1F)),
            Key(period, width = KeyWidth.FractionWidth(.1F)),
            Key(text = "", label = "⏎", width = KeyWidth.FractionWidth(.15F), specialKey = SpecialKey.ENTER)
        )
    } else listOf(
        Key(comma, width = KeyWidth.FractionWidth(.1F)),
        Key(text = "", label = "⛭", width = KeyWidth.FractionWidth(.1F), specialKey = SpecialKey.CHANGELAYOUT),
        Key(space, label = "␣", width = KeyWidth.FractionWidth(.3F)),
        Key("'", width = KeyWidth.FractionWidth(.1F)),
        Key(period, width = KeyWidth.FractionWidth(.1F)),
        Key(text = "", label = "⏎", width = KeyWidth.FractionWidth(.15F), specialKey = SpecialKey.ENTER)
    )
}
fun shiftKey(weight: Float): Key {
    return Key(text = "", label = "⌃", width = KeyWidth.WeightWidth(weight), specialKey = SpecialKey.SHIFT /*moveToLayer = 3*/)
}
fun unShiftKey(weight: Float): Key {
    return Key(text = "", label = "⌄", width = KeyWidth.WeightWidth(weight), specialKey = SpecialKey.UNSHIFT)
}
fun backSpaceKey(weight: Float, rightToLeft: Boolean = false): Key {
    return Key(text = "", label = if (rightToLeft) "⌦" else "⌫", width = KeyWidth.WeightWidth(weight),
        specialKey = SpecialKey.BACKSPACE)
}
//val symbolsKey1 = Key(text = "", label = "?12", width = KeyWidth.FractionWidth(.15F), moveToLayer = 1)
fun symbolsKey1(width: KeyWidth = KeyWidth.FractionWidth(.15F)): Key {
    return Key(text = "", label = "?12", width = width, moveToLayer = 1)
}
val symbolsKey2 = Key(text = "", label = "={", moveToLayer = 2)
val alphabetKey = Key(text = "", label = "AB", width = KeyWidth.FractionWidth(.15F), moveToLayer = 0)

val symbols1 = """
1 2 3 4 5 6 7 8 9 0
! @ # $ % ^ & * ( )
" - : ; ¤ + ? /
""".trim()
val symbols2 = """
~ ` | • √ π ÷ × § ∆
£ ¢ € ¥ ¿ ° = { } \
< > _ © ® ™ ✓ [ ]
""".trim()

val inBuiltSimpleLayoutsString = """
Abkhaz
ӷ қ ҟ ԥ ҭ ҳ ҷ ҿ ә
ҵ ц у к е н г ш ӡ з х
ф ы в а п р о л д ж ҽ
џ ч с м и т ь б ҩ

Albanian
q w e r t z u i o p
a s d f g h j k l ë
y x c v b n m ç

Altai
ё ј ҥ ӧ ӱ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Arapaho
é í ó ú 3
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Bashkir
ё ә ө ҡ ғ ҫ ҙ һ ү ң ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Brahui (Latin)
á ş đ ŕ ŧ ģ ú í ń ź
q w e r t y u i o p
a s d f g h j k l ļ
z x c v b n m

Breton
â ñ ê ü û î ô ù
a z e r t y u i o p
q s d f g h j k l m
w x c v b n

Bulgarian (ЯВЕРТЪ)
я в е р т ъ у и о п ч
а с д ф г х й к л ш щ
з ь ц ж б н м ю

Bulgarian (УЕИШЩ)
ѝ у е и ш щ к с д з ц
ь я а о ж г т н в м ч
ю й ъ ф х п р л б

Buryat (Mongolia)
е щ һ ъ ю
ф ц у ж э н г ш ү з к
й ы б ө а х р о л д п
я ч ё с м и т ь в

Buryat (Russia)
ё ө ү һ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Cahuilla
č ʷ kʷ l̃ ñ ŋ š xʷ ɂ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Caucasian
ё « Ӏ » ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chukchi
ё ӄ ԓ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chulym
ё ғ ҥ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chuvash
ё ӑ ӗ ҫ ӳ ъ - ! ? "
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Coptic
ⲋ ϥ ϩ ϫ ϭ ϯ ⳁ
ϧ ϣ ⲉ ⲣ ⲧ ⲩ ⲑ ⲓ ⲟ ⲡ
ⲁ ⲥ ⲇ ⲫ ⲅ ⲏ ⲝ ⲕ ⲗ
ⲍ ⲭ ⲯ ⲱ ⲃ ⲛ ⲙ

Czech
ď ě š č ř ž ý á í é ň
q w e r t z u i o p ú
a s d f g h j k l ů ó
y x c v b n m

Danish(/Norwegian)
q w e r t y u i o p å
a s d f g h j k l æ ø
z x c v b n m

Dungan
ё ә җ ң ү ў ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Enets
ё ԑ ӊ о̂ ˮ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Esperanto
ŝ ĝ e r t ŭ u i o p
a s d f g h j k l ĵ
z ĉ c v b n m ĥ

Estonian
q w e r t y u i o p ü
a s d f g h j k l ö ä
z x c v b n m õ

Even
ё ӈ ө ӫ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Evenki
ё̄ э̄
ё а̄ ӯ ӣ е̄ ӈ ы̄ о̄ я̄ ю̄ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Faroese
ð í ó ú ý æ ø
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Finnish/Swedish
q w e r t y u i o p å
a s d f g h j k l ö ä
z x c v b n m

Fula
q w e r t y u i o p ƴ
a s d f g h j k l ɗ ɓ
z x c v b n m ŋ ɲ

German
q w e r t z u i o p ü
a s d f g h j k l ö ä
y x c v b n m ß

Hausa
q w e r t y u i o p ƴ
a s d f g h j k l ƙ
z x c v b n m ɓ ɗ

Ho
𑣿 𑣛 𑣛 𑣆 𑣊 𑣍 𑣐
𑣄 𑣒 𑣈 𑣜 𑣕 𑣅 𑣃 𑣂 𑣉 𑣉
𑣁 𑣞 𑣔 𑣑 𑣋 𑣙 𑣎 𑣌 𑣚
𑣀 𑣝 𑣏 𑣟 𑣗 𑣓 𑣖

Ho-Chunk (Wisconsin)
ą ǧ į š ų ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Hungarian
á é í ó ö ő ú ü ű -
q w e r t z u i o p
a s d f g h j k l
y x c v b n m

Icelandic
á æ é ð þ ý ú í ó ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ingrian
q w e r t y u i o p š
a s d f g h j k l ö ä
z x c v b n m ž

Iñupiaq
ġ ḷ ł ł̣ ñ ŋ r̂
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Italian
à ç è é ì ò ó ù
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Javanese (Latin)
q w e r t y u i o p
a s d f g h j k l é
z x c v b n m è

Karakalpak (Cyrillic)
ё ў ү қ ә ң ғ ө ҳ ? ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Kazakh (Cyrillic)
ё ә і ң ғ ү ұ қ ө һ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ket
ё ӄ ә ӈ ӷ ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Khakas
ё ғ і ң ӧ ӱ ӌ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Khasi
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m ï

Koryak
ё вʼ гʼ ӄ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Kurdish (Kurmanji) (Latin)
q w e r t y u i o p û
a s d f g h j k l ê î
z x c v b n m ç ş

Kyrgyz
ё ң ө ү ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Lakota
á č é ǧ ȟ ŋ ú í ó š
q w e r t y u i o p
a s d f g h j k l
z x c v b n m ž

Latvian (Big)
ā č ē ģ ķ ņ ū ī š ž
q w e r t y u i o p
a s d f g h j k l ļ
z x c v b n m

Laz (Latin)
ç ǧ ǩ p̌ ş t‌̌ ž ʒ ǯ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Lithuanian
ą č ę ė į š ų ū ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ludic/Veps
č š ž ü ä ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Macedonian
љ њ е р т ѕ у и о п ш
а с д ф г х й к л ч ќ
з џ ц в б н м ѓ ж

Mansi (Northern) (Big)
ё̄ ъ
ё ы̄ ӯ а̄ е̄ ӈ о̄ я̄ ю̄ ӣ э̄
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Mari (All)
ё ӓ ӹ ө ӫ ҥ ӧ ӱ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Marshallese
ā l‌̧ m̧ n‌̧ n̄ o̧ ō
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Mi'kmaq
á é í ó ú ɨ ꞌ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Mongolian (Cyrillic)
е щ « » ъ ю
ф ц у ж э н г ш ү з к
й ы б ө а х р о л д п
я ч ё с м и т ь в

Nanai
ё ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nenets
ё ʼ ˮ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nganasan
ё з̌ ˮ ӈ ө ү ә ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nivkh
ё ӷ ў ӄ ғ ӈ ӻ р̌ ӽ ӿ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

O'odham
ḏ ḍ ñ ŋ ṣ :
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ossetian
ё « ӕ » ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Polish
ą ć ę ł n ó ś ź ż
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Romanian
q w e r t y u i o p ă
a s d f g h j k l ș ț
z x c v b n m î â

Russian
ё ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Rusyn (All)
ё ӯ ӱ ы о̄ ґ о̂ ї ъ
й ц у к е н г ш щ з х
ф і в а п р о л д ж є
я ч с м и т ь б ю

Sami (Kildin) (Big)
ё̄ ӊ ӈ о̄ ҏ ӯ э̄ ӭ ю̄ я̄ ҍ
ё а̄ ӓ е̄ һ ӣ ј ҋ ӆ ӎ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Sami (Lule)
q w e r t y u i o p å
a s d f g h j k l á ä
z x c v b n m ŋ

Sami (Northern)
á č đ ŋ š ŧ ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Sami (Skolt)
â č ʒ ǯ đ ǩ š ž å ä ʹ
q w e r t y u i o p õ
a s d f g h j k l ǧ ǥ
z x c v b n m ŋ ž

Sami (Southern)
q w e r t y u i o p å
a s d f g h j k l ö æ
z x c v b n m ï

Sami (Ume)
á đ ï ŋ ŧ ü å ä ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Serbo-Croatian (Cyrillic)
љ њ е р т з у и о п ш
а с д ф г х й к л ч ћ
џ ц в б н м ђ ж

Serbo-Croatian (Latin)
q w e r t z u i o p š
a s d f g h j k l č ć
y x c v b n m ž đ

Shuswap
q̓ w̓ n̓ r̓ t̓ y̓ g̓ k̓ m̓ p̓
q w e r t y u i o p
a s d f g h j k l l̓
z x c v b n m 7

Slovak (Big)
ď ĺ ň ó ô ŕ ú
ľ š č ť ž ý á í é ä
q w e r t z u i o p
a s d f g h j k l
y x c v b n m

Slovene
q w e r t z u i o p š
a s d f g h j k l č ž
y x c v b n m

Spanish
á é ñ ¿ ¡ ú í ó ü
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Tajik
ё ғ ӯ ъ
й қ у к е н г ш ҳ з х
ф ҷ в а п р о л д ж э
я ч с м и т ӣ б ю

Tatar (Cyrillic)
ё һ ү җ ә ң ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Tofa
ё і ү қ ә ң ғ ө һ ҷ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Turkmen
ä ş ç ž ň ý ü ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Udege (Petersburg)
ё ԝ ә ӡ њ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ukrainian
ґ ₴ ї
й ц у к е н г ш щ з х
ф і в а п р о л д ж є
я ч с м и т ь б ю

Uzbek (Cyrillic)
ё ғ ҳ ъ
й ц у к е н г ш ў з х
ф қ в а п р о л д ж э
я ч с м и т ь б ю

Uzbek (Latin)
q w e r t y u i o p oʻ
a s d f g h j k l gʻ ʼ
z x c v b n m

Venda
ḓ ḽ ṋ ṅ ṱ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Votic
ä ö õ ü š ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Wadul/Tundra Yukaghir
ё ҕ ҥ ө ԝ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Welsh
â ê î ô û ŵ ŷ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Yaghnobi
ё ғ ԝ ӯ ъ
й қ у к е н г ш ҳ з х
ф ҷ в а п р о л д ж э
я ч с м и т ӣ б ю

Yakut
ё нь дь ҥ ҕ ө һ ү ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю
""".trim()

val layouts = listOf(
    Layout(
        name = "Armenian",
        layout = """
            « ՝ ՜ ՞ ՛ . »
            է թ փ ձ ջ և ր չ ճ ժ
            ք ո ե ռ տ ը ւ ի օ պ խ
            ա ս դ ֆ գ հ յ կ լ ծ
            զ ղ ց վ բ ն մ շ
        """.trimIndent(),
        period = "։"
    ),
    Layout(
        name = "Azerbaijani (Cyrillic)",
        layout = """
            ј ү у к е н г ш һ з х
            ф ы в а п р о л д ж ҝ
            ә ч с м и т ғ б ө
        """.trimIndent(),
        bottomRowKey = Key(text = "ҹ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Azerbaijani (Latin)",
        layout = """
            ə ç ğ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ə Ç Ğ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Belarusian",
        layout = """
            й ц у к е н г ш ў з х
            ф ы в а п р о л д ж э
            я ч с м і т ь б ю
        """.trimIndent(),
        bottomRowKey = Key(text = "ё", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Blackfoot (Syllabics)",
        layout = """
            ᑉ ᐤ ᐨ ᘁ ᐢ ᐡ ᔈ ᐟ ᐠ ᙿ
            ᖲ ᑲ ᒪ ᖾ ᒐ ᖺ ᓴ ᔭ ᖶ ᐧ
            ᖱ ᑯ ᒧ ᖽ ᒍ ᖹ ᓱ ᔪ ᖵ ᐦ
            ᖰ ᑭ ᒥ ᖼ ᒋ ᖸ ᓯ ᔨ ᖴ ᑊ
            ᖳ ᑫ ᒣ ᖿ ᒉ ᖻ ᓭ ᔦ ᖷ
        """.trimIndent(),
        hasShift = false,
        period = "᙮"
    ),
    /*Layout(
        name = "Burmese/Myanmar",
        layout = """
            ဈ ဝ ဋ ုံ ော ဪ ရ ဂ ဟ ၏
            ဆ တ န မ အ ပ က င သ စ
            ‌ေ ျ ိ ် ါ ့ ြ ု ူ း
            ဖ ထ ခ လ ဘ ည ာ ယ
        """.trimIndent(),
        capsLayer = """
            ၁ ၂ ၃ ၄ ၅ ၆ ၇ ၈ ၉ ၀
            ဍ ဏ္ဍ ဣ ၎င်း ဤ ၌ ဥ ၍ ဿ ဏ
            ဗ ှ ီ ္ ွ ံ ဲ ဒ ဓ ဏ္ဌ
            ဇ ဌ ဃ ဠ ဎ ဉ ဦ ဧ
        """.trimIndent()
    ),*/
    Layout(
        name = "Georgian (ქწერტყ)",
        layout = """
            „ ჭ ღ თ შ ჟ ძ ჩ “
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        capsLayer = """
            „ ჭ ღ თ შ ჟ ძ ჩ “
            ქ ჭ ე ღ თ ყ უ ი ო პ
            ა შ დ ფ გ ჰ ჟ კ ლ
            ძ ხ ჩ ვ ბ ნ მ
        """.trimIndent()
    ),
    Layout(
        name = "Georgian (ღჯუკენ)",
        layout = """
            ღ ჯ უ კ ე ნ გ შ ზ ხ ც
            ფ ძ ვ თ ა პ რ ო ლ დ ჟ
            ჭ ჩ ყ ს მ ი ტ ქ ბ ჰ
        """.trimIndent(),
        hasShift = false,
        bottomRowKey = Key(text = "წ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Hebrew",
        layout = """
            ' - ק ר א ט ו ן ם פ
            ש ד ג כ ע י ח ל ך ף
            ז ס ב ה נ מ צ ת ץ
        """.trimIndent(),
        hasShift = false,
        rightToLeft = true
    ),
    Layout(
        name = "Karakalpak (Latin)",
        layout = """
            á ǵ ı ń ó ú
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Á Ǵ Í Ń Ó Ú
            Q W E R T Y U I O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Kazakh (Latin)",
        layout = """
            ä ı ñ ğ ü ū ş ö ç
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ä I Ñ Ğ Ü Ū Ş Ö Ç
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Kurdish (Arabic)",
        layout = """
            ع ش ڕ غ ڵ ێ چ ؟
            ق و ە ر ت ی ئ ح ۆ پ
            ا س د ف گ ه ژ ک ل
            ز خ ج ڤ ب ن م
        """.trimIndent(),
        capsLayer = """
            ع ش ڕ غ ڵ ێ چ ؟
            ` وو ي ڕ ط ێ ء ع ؤ ث
            آ ش ذ إ غ ه أ ك ڵ
            ض ص چ ظ ى ة ـ
        """.trimIndent(),
        rightToLeft = true
    ),
    Layout(
        name = "Laz (Mkhedruli)",
        layout = """
            ჶ ჭ თ შ ღ ჟ ძ ჩ
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ჲ ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        hasShift = false
    ),
    Layout(
        name = "Lisu",
        layout = """
            ꓥ ꓭ ꓷ ꓸ ꓹ ꓺ ꓻ ꓼ ꓽ ˍ
            ꓘ ꓛ ꓱ ꓤ ꓕ ꓞ ꓵ ꓨ ꓩ ꓒ
            ꓯ ꓪ ꓰ ꓣ ꓔ ꓬ ꓴ ꓲ ꓳ ꓑ
            ꓮ ꓢ ꓓ ꓝ ꓖ ꓧ ꓙ ꓗ ꓡ ꓶ
            ꓜ ꓫ ꓚ ꓦ ꓐ ꓠ ꓟ
        """.trimIndent(),
        capsLayer = """
            ꓥ ꓭ ꓷ ꓸ ꓹ ꓺ ꓻ ꓼ ꓽ ˍ
            ꓘ ꓛ ꓱ ꓤ ꓕ ꓞ ꓵ ꓨ ꓩ ꓒ
            ꓯ ꓪ ꓱ ꓤ ꓕ ꓻ ꓵ ꓹꓼ ˍ ꓒ
            ꓯ ꓽ ꓷ ꓞ ꓨ ꓺ ꓩ ꓘ ꓶ ꓶ
            ꓹ ꓸ ꓛ ꓥ ꓭ - ꓸꓼ
        """.trimIndent(),
        comma = "꓾",
        period = "꓿"
    ),
    Layout(
        name = "Mansi (Northern) (Small)",
        layout = """
            ё ¯ ӈ ъ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ¯ ӈ ъ
            й ц ӯ к е̄ н г ш щ з х
            ф ы̄ в а̄ п р о̄ л д ж э̄
            я̄ ч с м ӣ т ь б ю̄
        """.trimIndent()),
        moveLayerKeys = listOf("¯"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Mingrelian",
        layout = """
            ჸ ჭ თ შ ღ ჟ ძ ჩ ჷ
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ჲ ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        hasShift = false
    ),
    /*Layout(
        name = "Mongolian (Mongolian Script)",
        layout = """
            ᠸ ᠧ ᠿ ᠾ ᠻ ᡀ ᡂ ᠩ
            ᠴ ᠣ ᠡ ᠷ ᠲ ᠶ ᠦ ᠢ ᠥ ᠫ
            ᠠ ᠰ ᠳ ᠹ ᠭ ᠬ ᠵ ᠺ ᠯ
            ᡁ ᠽ ᠱ ᠼ ᠤ ᠪ ᠨ ᠮ
        """.trimIndent(),
        hasShift = false
    ),*/
    Layout(
        name = "Mro/Mru",
        layout = """
            𖩡 𖩢 𖩣 𖩤 𖩥 𖩦 𖩧 𖩨 𖩩 𖩠
            𖩈 𖩗 𖩘 𖩓 𖩀 𖩂 𖩑 𖩊 𖩝 𖩐 𖩙
            𖩆 𖩔 𖩅 𖩇 𖩁 𖩉 𖩜 𖩌 𖩍 𖩚 𖩛
            𖩖 𖩕 𖩒 𖩋 𖩞 𖩄 𖩏 𖩃 𖩎
        """.trimIndent(),
        hasShift = false,
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Ojibwe (Syllabics a-finals)",
        layout = """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᔥ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᔓ ᐧ
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᔑ ˙
            ᐁ ᐯ ᑌ ᑫ ᒣ ᓀ ᓭ ᔦ ᒉ ᔐ ?
            ᐊ ᐸ ᑕ ᑲ ᒪ ᓇ ᓴ ᔭ ᒐ ᔕ
        """.trimIndent(),
        otherLayers = listOf("""
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᔥ ᐤ
            ᐆ ᐴ ᑑ ᑰ ᒨ ᓅ ᓲ ᔫ ᒎ ᔔ ᐧ
            ᐄ ᐲ ᑏ ᑮ ᒦ ᓃ ᓰ ᔩ ᒌ ᔒ ˙
            ᐁ ᐯ ᑌ ᑫ ᒣ ᓀ ᓭ ᔦ ᒉ ᔐ ?
            ᐋ ᐹ ᑖ ᑳ ᒫ ᓈ ᓵ ᔮ ᒑ ᔖ
        """.trimIndent()),
        moveLayerKeys = listOf("˙"),
        hasShift = false
    ),
    Layout(
        name = "Rusyn (Pannonian)",
        layout = """
            й ц у к е н г ш щ з х
            ф ї в а п р о л д ж є
            я ч с м и т ь б ю
        """.trimIndent(),
        bottomRowKey = Key(text = "ґ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Sami (Kildin) (Small)",
        layout = """
            ё ј һ ¯ ӭ ӈ ӓ , ъ ҍ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ј һ ¯ ӭ̄ ӈ ӓ̄ , ъ ҍ
            й ц ӯ к е̄ н г ш щ з х
            ф ы̄ в а̄ п р о̄ л д ж э̄
            я̄ ч с м ӣ т ь б ю̄
        """.trimIndent(), """
            ё ј һ ¯ ӭ ӈ ӓ , ъ ҍ
            ҋ ц у к е ӊ г ш щ з х
            ф ы в а п ҏ о ӆ д ж э
            я ч с ӎ и т ь б ю
        """.trimIndent()),
        moveLayerKeys = listOf("¯", ","),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Santali",
        layout = """
            ᱚ ᱽ ᱹ ᱸ ᱺ ᱻ ᱼ
            ᱧ ᱣ ᱮ ᱨ ᱛ ᱭ ᱩ ᱤ ᱳ ᱯ
            ᱟ ᱥ ᱫ ᱝ ᱜ ᱷ ᱦ ᱡ ᱠ ᱞ
            ᱲ ᱰ ᱪ ᱶ ᱵ ᱱ ᱬ ᱢ ᱴ
        """.trimIndent(),
        hasShift = false
    ),
    Layout(
        name = "Selkup (Southern)",
        layout = """
            ҷ ӽ ъ
            ё и̇ ӱ ӄ ӓ ӈ ӷ ӧ ¯ җ ´
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ҷ ӽ ъ
            ё̄ и̇̄ ӱ̄ ӄ ӓ̄ ӈ ӷ ӧ̄ ¯ җ ´
            й ц ӯ к е̄ н г ш щ з х
            ф ы̄ в а̄ п р о̄ л д ж э̄
            я̄ ч с м ӣ т ь б ю̄
        """.trimIndent(), """
            ҷ ӽ ъ
            ё́ и̇́ ӱ́ ӄ ӓ́ ӈ ӷ ӧ́ ¯ җ ´
            й ц у́ к е́ н г ш щ з х
            ф ы́ в а́ п р о́ л д ж э́
            я́ ч с м и́ т ь б ю́
        """.trimIndent()),
        moveLayerKeys = listOf("¯", "´"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Sora",
        layout = """
            𑃧 𑃣 𑃝 𑃑 𑃜 𑃥 𑃤 𑃦 𑃛
            𑃢 𑃐 𑃔 𑃗 𑃕 𑃞 𑃠 𑃟 𑃘
            𑃨 𑃡 𑃓 𑃚 𑃒 𑃙 𑃖
        """.trimIndent(),
        hasShift = false,
    ),
    Layout(
        name = "Taiwanese Hokkien (POJ)",
        layout = """
            ´ ` ^ ¯ ˈ o͘ ⁿ ng -
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ´ ` ^ ¯ ˈ ó͘ ⁿ ńg -
            q w é r t y ú í ó p
            á s d f g h j k l
            z x c v b ń ḿ
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ò͘ ⁿ ǹg -
            q w è r t y ù ì ò p
            à s d f g h j k l
            z x c v b ǹ m̀
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ô͘ ⁿ n̂g -
            q w ê r t y û î ô p
            â s d f g h j k l
            z x c v b n̂ m̂
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ō͘ ⁿ n̄g -
            q w ē r t y ū ī ō p
            ā s d f g h j k l
            z x c v b n̄ m̄
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ o̍͘ ⁿ n̍g -
            q w e̍ r t y u̍ i̍ o̍ p
            a̍ s d f g h j k l
            z x c v b n̍ m̍
        """.trimIndent()),
        moveLayerKeys = "´ ` ^ ¯ ˈ".split(' ')
    ),
    /*Layout(
        name = "Thai",
        layout = """
            ๅ / _ ภ ถ ุ ึ ค ต จ ข ช
            ๆ ไ ำ พ ะ ั ี ร น ย บ ล
            ฟ ห ก ด เ ้ ่ า ส ว ง ฃ
            ผ ป แ อ ิ ื ท ม ใ ฝ
        """.trimIndent(),
        capsLayer = """
            + ๑ ๒ ๓ ๔ ู ฿ ๕ ๖ ๗ ๘ ๙
            ๐ " ฎ ฑ ธ ํ ๊ ณ ฯ ญ ฐ ,
            ฤ ฆ ฏ โ ฌ ็ ๋ ษ ศ ซ . ฅ
            ( ) ฉ ฮ ฺ ์ ? ฒ ฬ ฦ
        """.trimIndent()
    ),*/
    Layout(
        name = "Turkish",
        layout = """
            ç ğ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ç Ğ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Udege (Khabarovsk)",
        layout = """
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц ӯ к е н г ш щ з х
            ф ы в а̄ п р о̄ л д ж э̄
            я ч с м ӣ т ь б ю
        """.trimIndent(), """
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц у̂ к е н г ш щ з х
            ф ы в а̂ п р о̂ л д ж э̂
            я ч с м и̂ т ь б ю
        """.trimIndent()),
        moveLayerKeys = listOf("¯", "^")
    ),
    Layout(
        name = "Uyghur (Arabic)",
        layout = """
            ژ ف گ خ ج ۆ لا ؟
            چ ۋ ې ر ت ي ۇ ڭ و پ
            ھ س د ا ە ى ق ك ل
            ز ش غ ۈ ب ن م ئ
        """.trimIndent(),
        capsLayer = """
            ژ ف گ خ ج ۆ لا ؟
            چ ۋ ې ر ت ي ۇ ڭ و پ
            ھ س ژ ف گ خ ج ۆ لا
            ز ش غ ۈ ب ن م ؟
        """.trimIndent(),
        rightToLeft = true
    )
)

val inBuiltLayouts = listOf(Layout(
    name = "English (QWERTY)",
    layout = """
        q w e r t y u i o p
        a s d f g h j k l
        z x c v b n m
    """.trimIndent()
).compile()) +
        (inBuiltSimpleLayoutsString.split("\n\n").map {
    val splitLayoutString = it.split("\n", limit = 2)
    Layout(
        name = splitLayoutString[0],
        layout = splitLayoutString[1],
        decoupleRows = if (splitLayoutString[1][0] == 'ё' || splitLayoutString[1][0] == 'е' || splitLayoutString[1][0] == 'ґ'
            || splitLayoutString[1].split('\n')[0].split(' ').size <= 6) listOf(0) else emptyList()
    )
} + layouts).map { //Log.d("MyTag", it.name)
            it.compile() }.sortedBy { it.name }