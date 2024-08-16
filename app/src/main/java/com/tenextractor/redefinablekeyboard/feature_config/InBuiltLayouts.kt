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
val zwnjKey = Key(text = "‌", label = "‹|›", width = KeyWidth.FractionWidth(.1F))

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
3 é í ó ú
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Bashkir
ё ә ө ҡ ғ ҫ ҙ һ ү ң ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Belarusian (Latin)
ć č ź ž ń ŭ ś š ł
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Berber/Tamazight (AZERTY)
č ẓ ɛ ṛ ṭ ɣ ǧ ḥ ř ṣ
a z e r t y u i o p
q s d f g h j k l m
w x c v b n ḍ

Berber/Tamazight (QWERTY)
č ẓ ɛ ṛ ṭ ɣ ǧ ḥ ř ṣ
q w e r t y u i o p
a s d f g h j k l ḍ
z x c v b n m

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

Catalan
à ç é ï ŀ ü ú í ó ò
q w e r t y u i o p
a s d f g h j k l è
z x c v b n m

Caucasian
ё « Ӏ » ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chamorro
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m å

Cheyenne
á ȧ â é ė ê ó ȯ ô š
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

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
ⲋ ϥ ϩ ϫ ϭ ϯ ⳁ ◌̀
ϧ ϣ ⲉ ⲣ ⲧ ⲩ ⲑ ⲓ ⲟ ⲡ
ⲁ ⲥ ⲇ ⲫ ⲅ ⲏ ⲝ ⲕ ⲗ
ⲍ ⲭ ⲯ ⲱ ⲃ ⲛ ⲙ

Cree (Latin)
ê š ð â û î ô
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Czech
ď ě š č ř ž ý á í é ň
q w e r t z u i o p ú
a s d f g h j k l ů ó
y x c v b n m

Dagbani
q w e r t y u i o p ɣ
a s d f g h j k l ɔ ɛ
z x c v b n m ʒ ŋ

Danish(/Norwegian)
q w e r t y u i o p å
a s d f g h j k l æ ø
z x c v b n m

Dinka
ä ɛ ë ɛ̈ ɣ ŋ ɔ ï ö ɔ̈
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Dungan
ё ә җ ң ү ў ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Efik
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m ọ

Enets
ё ԑ ӊ о̂ ˮ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

English (Colemak)
q w f p g j l u y ;
a r s t d h n e i o
z x c v b k m

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

Ewe
ɖ ɛ ƒ ɣ ŋ ɔ ʋ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Farefare/Frafra
ŋ ã ɛ ẽ ĩ õ ʋ ɩ ɔ ũ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Faroese
ð æ ø ý ú í ó
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Finnish/Swedish
q w e r t y u i o p å
a s d f g h j k l ö ä
z x c v b n m

Fulani/Fulfulde (All)
ɓ ɗ ɠ ɲ ƴ ñ n̰ ŋ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Fulani/Fulfulde (Maasina)
q w e r t y u i o p ƴ
a s d f g h j k l ɗ ɓ
z x c v b n m ŋ ɲ

Garo
q w e r t y u i o p
a s d f g h j k l ·
z x c v b n m

German
q w e r t z u i o p ü
a s d f g h j k l ö ä
y x c v b n m ß

German (Neo 2)
x v l c w k h g f q ß
u i a e o s n r t d y
ü ö ä p z b m j

German (Switzerland)
q w e r t z u i o p ü
a s d f g h j k l ö ä
y x c v b n m

Gĩkũyũ/Kikuyu
q w e r t y u i o p
a s d f g h j k l ĩ
z x c v b n m ũ

Gitxsan
q w e r t y u i o p
a s d f g h j k l ḵ
z x c v b n m x̱

Guaymí/Ngäbere
q w e r t y u i o p ü
a s d f g h j k l ñ ä
z x c v b n m ö

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

Ingrian/Izhorian
q w e r t y u i o p š
a s d f g h j k l ö ä
z x c v b n m ь ž

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

Karelian
č š ž ä ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Kashubian
ą ã ë é ń ô ù ó ò ż
q w e r t y u i o p
a s d f g h j k l ł
z x c v b n m

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

Komi
ё і ӧ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

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

Māori
ā ē ī ō ū
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

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

Massachusett/Wampanoag
q w e r t y u i o p ô
a s d f g h j k l â 8
z x c v b n m

Menominee
ā ē æ ǣ ö ū ī ō
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

Navajo (Big)
á ą ą́ é ę ę́ í į į́ ó ǫ
q w e r t y u i o p ǫ́
a s d f g h j k l ł
z x c v b n m

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

Nisga'a
ḵ w̓ x̱ l̓ y̓ n̓ m̓
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Nivkh
ё ӷ ў ӄ ғ ӈ ӻ р̌ ӽ ӿ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nuxalk
q w e r t y u i o p
a s d f g h j k l 7
z x c v b n m

O'odham
ḏ ḍ ñ ŋ ṣ :
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Odun/Forest Yukaghir
ё җ қ ә ҥ ҕ ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

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

Russian (Phonetic)
ё ъ
я ш е р т ы у и о п ч
а с д ф г х й к л ж э
з ь ц в б н м ю щ

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

Sami (Pite)
á đ ŋ ŧ å ä
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
á đ å ŧ ŋ ü ï ö ä
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

Setswana
q w e r t y u i o p š
a s d f g h j k l ô ê
z x c v b n m

Shuswap
q̓ w̓ n̓ r̓ t̓ y̓ g̓ k̓ m̓ p̓
q w e r t y u i o p
a s d f g h j k l l̓
z x c v b n m 7

Siberian Tatar
ё ө ү ҡ ә ң ғ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

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

Sundanese (Latin)
q w e r t y u i o p
a s d f g h j k l é
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

Tłı̨chǫ (Big)
à ą ą̀ è ę ę̀ ì ı̨ į̀ ò ǫ
q w e r t y u ı o p ǫ̀
a s d f g h j k l ł i
z x c v b n m

Tofa
ё і ү қ ә ң ғ ө һ ҷ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Tsimshian (Coast)
ḵ ẅ a̰ ɫ ü g̲
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Tswa
q w e r t y u i o p ṅ
a s d f g h j k l ŝ ẑ
z x c v b n m

Tumbuka
q w e r t y u i o p
a s d f g h j k l ŵ
z x c v b n m

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

Ute
q w e r t y u i o p
a s d f g h j k l ɵ
z x c v b n m ʉ

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
š ž ü ä ö õ
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

Zazaki
ç ê ğ ş û î
q w e r t y u i o p
a s d f g h j k l
z x c v b n m
""".trim()

val layouts = listOf(
    Layout(
        name = "Arabic (101)",
        layout = """
            ض ص ث ق ف غ ع ه خ ح ج
            ش س ي ب ل ا ت ن م ك ط
            ذ ئ ء ر ة و ز ظ د
        """.trimIndent(),
        capsLayer = """
            ◌َ ◌ً ◌ُ ◌ٌ لإ إ ‘ ÷ × ؛ <
            ◌ِ ◌ٍ ] [ لأ أ ـ , / : "
            ◌ّ ى ◌ْ آ ’ ؤ . ؟ >
        """.trimIndent(),
        comma = "،",
        rightToLeft = true
    ),
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
        name = "Belarusian (Cyrillic)",
        layout = """
            й ц у к е н г ш ў з х
            ф ы в а п р о л д ж э
            я ч с м і т ь б ю
        """.trimIndent(),
        bottomRowKey = Key(text = "ё", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Bengali (InScript)",
        layout = """
            ◌ৌ ◌ৈ ◌া ◌ী ◌ূ ব হ গ দ জ ড
            ◌ো ◌ে ◌্ ◌ি ◌ু প র ক ত চ ট
            ◌় ◌ং ম ন ◌ৃ ল স শ য়
        """.trimIndent(),
        capsLayer = """
            ঔ ঐ আ ঈ ঊ ভ ঙ ঘ ধ ঝ ঢ
            ও এ ◌্ ই উ ফ ৎ খ থ ছ ঠ
            ঞ ◌ঁ ণ ঃ ঋ . ॥ ষ য
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
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
    Layout(
        name = "Brahui (Arabic)",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط ذ
            ق و ع ر ت ے ء ی ہ پ ڷ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠ ,
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ن٘
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
    ),
    Layout(
        name = "Burmese/Myanmar",
        layout = """
            ဈ ဝ ဋ ◌ုံ ော ဪ ရ ဂ ဟ ၏
            ဆ တ န မ အ ပ က င သ စ
            ‌ေ ◌ျ ◌ိ ◌် ◌ါ ◌့ ြ ◌ု ◌ူ ◌း
            ဖ ထ ခ လ ဘ ည ◌ာ ယ
        """.trimIndent(),
        capsLayer = """
            ၁ ၂ ၃ ၄ ၅ ၆ ၇ ၈ ၉ ၀
            ဍ ဏ္ဍ ဣ ၎င်း ဤ ၌ ဥ ၍ ဿ ဏ
            ဗ ◌ှ ◌ီ ◌္ ◌ွ ◌ံ ◌ဲ ဒ ဓ ဏ္ဌ
            ဇ ဌ ဃ ဠ ဎ ဉ ဦ ဧ
        """.trimIndent()
    ),
    Layout(
        name = "Crimean Tatar (Latin)",
        layout = """
            ç ğ ş ñ ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ç Ğ Ş Ñ Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "English (Dvorak)",
        layout = """
            ' , . p y f g c r l
            a o e u i d h t n s
            j k x b m w v z
        """,
        bottomRowKey = Key(text = "q", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "French (AZERTY)",
        layout = """
            à é è ê ç â û ¨ ô œ
            a z e r t y u i o p
            q s d f g h j k l m
            w x c v b n ù
        """.trimIndent(),
        otherLayers = listOf("""
            à é è ê ç â û ¨ ô œ
            ä z ë r t ÿ ü ï ö p
            q s d f g h j k l m
            w x c v b n ù
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (BÉPO)",
        layout = """
            â ù ô û ¨ æ œ
            b é p o è v d l j z w
            a u i e c t s r n m ç
            ê à y x k q g h f
        """.trimIndent(),
        otherLayers = listOf("""
            â ù ô û ¨ æ œ
            b é p ö è v d l j z w
            ä ü ï ë c t s r n m ç
            ê à ÿ x k q g h f
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (QWERTY)",
        layout = """
            à û è ê ç â ù ¨ ô œ
            q w e r t y u i o p
            a s d f g h j k l é
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            à û è ê ç â ù ¨ ô œ
            q w ë r t ÿ ü ï ö p
            ä s d f g h j k l é
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (QWERTZ)",
        layout = """
            à û è ê ç â ù ¨ ô œ
            q w e r t z u i o p
            a s d f g h j k l é
            y x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            à û è ê ç â ù ¨ ô œ
            q w ë r t z ü ï ö p
            ä s d f g h j k l é
            ÿ x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "Gagauz",
        layout = """
            ä ê ç ţ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ä Ê Ç Ţ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
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
        name = "Guarani",
        layout = """
            ʼ ã ẽ g̃ ñ ỹ ũ ĩ õ ´
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ʼ ã́ ẽ́ g̃ ñ ỹ́ ṹ ĩ́ ṍ ´
            q w é r t ý ú í ó p
            á s d f g h j k l
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("´")
    ),
    Layout(
        name = "Gujarati (InScript)",
        layout = """
            ◌ૉ ◌ૅ ◌ૃ ◌ૄ
            ◌ૌ ◌ૈ ◌ા ◌ી ◌ૂ બ હ ગ દ જ ડ
            ◌ો ◌ે ◌્ ◌િ ◌ુ પ ર ક ત ચ ટ
            ◌઼ ◌ં મ ન વ લ સ શ ય
        """.trimIndent(),
        capsLayer = """
            ઑ ઍ ઋ ૠ
            ઔ ઐ આ ઈ ઊ ભ ઙ ઘ ધ ઝ ઢ
            ઓ એ અ ઇ ઉ ફ ર ખ થ છ ઠ
            ઞ ઁ ણ ન વ ળ ॥ ષ ◌ઃ
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
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
        name = "Hindi (Alternate)",
        layout = """
            ट ◌ौ ◌े र त य ◌ु ◌ि ◌ो प ◌ी
            ◌ा स द ◌ू ग ह ज क ल ◌ै ◌ं
            श ड च व ब न म ◌्
        """.trimIndent(),
        capsLayer = """
            ठ औ ए ◌ृ थ ञ उ इ ओ फ ई
            आ ऋ ध ऊ घ ङ झ ख ळ ऐ ◌ँ
            ष ढ छ ◌ः भ ण ़ अ
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Hindi (InScript)",
        layout = """
            ◌ॅ ऍ ◌ॉ ऑ ृ ऋ ़ ञ
            ◌ौ ◌ै ◌ा ◌ी ◌ू ब ह ग द ज ड
            ◌ो ◌े ◌् ि ◌ु प र क त च ट
            ◌ँ ◌ं म न व ल स श य
        """.trimIndent(),
        capsLayer = """
            ◌ॅ ऍ ◌ॉ ऑ ृ ऋ ़ ञ
            औ ऐ आ ई ऊ भ ङ घ ध झ ढ
            ओ ए अ इ उ फ ऱ ख थ छ ठ
            ◌ः ◌़ ण ऩ ऴ ळ ॥ ष य़
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Kannada (InScript)",
        layout = """
            ◌ೄ ◌ಃ ಞ
            ◌ೌ ◌ೈ ◌ಾ ◌ೀ ◌ೂ ಬ ಹ ಗ ದ ಜ ಡ
            ◌ೋ ◌ೇ ◌್ ◌ಿ ◌ು ಪ ರ ಕ ತ ಚ ಟ
            ◌ೊ ◌ೆ ◌ಂ ಮ ನ ವ ಲ ಸ ಯ
        """.trimIndent(),
        capsLayer = """
            ೠ ◌ಃ ಞ
            ಔ ಐ ಆ ಈ ಊ ಭ ಙ ಘ ಧ ಝ ಢ
            ಓ ಏ ಅ ಇ ಉ ಫ ಱ ಖ ಥ ಛ ಠ
            ಒ ಎ ೞ ಣ ◌ೃ ಋ ಳ ಶ ಷ
        """.trimIndent(),
        bottomRowKey = zwnjKey
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
        name = "Luxembourgish",
        layout = """
            ´ ` ^ ¨ ~
            q w e r t z u i o p ë
            a s d f g h j k l é ä
            y x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ´ ` ^ ¨ ~
            q w é r t z ú í ó p ë
            á s d f g h j k l é ä
            ý x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~
            q w è r t z ù ì ò p ë
            à s d f g h j k l é ä
            ỳ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~
            q w ê r t z û î ô p ë
            â s d f g h j k l é ä
            ŷ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~
            q w ë r t z ü ï ö p ë
            ä s d f g h j k l é ä
            ÿ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~
            q w ẽ r t z ũ ĩ õ p ë
            ã s d f g h j k l é ä
            ỹ x c v b ñ m
        """.trimIndent()),
        moveLayerKeys = "´ ` ^ ¨ ~".split(' ')
    ),
    Layout(
        name = "Malayalam (InScript)",
        layout = """
            ◌ൃ ◌ൄ ◌ഃ ർ ഞ ൽ ൿ ൾ റ്റ
            ◌ൌ ◌ൈ ◌ാ ◌ീ ◌ൂ ബ ഹ ഗ ദ ജ ഡ
            ◌ോ ◌േ ◌് ◌ി ◌ു പ ര ക ത ച ട
            ◌ൊ ◌െ ◌ം മ ന വ ല സ യ
        """.trimIndent(),
        capsLayer = """
            ഋ ൠ ◌ഃ ർ ഞ ൽ ൿ ൾ റ്റ
            ഔ ഐ ആ ഈ ഊ ഭ ങ ഘ ധ ഝ ഢ
            ഓ ഏ അ ഇ ഉ ഫ റ ഖ ഥ ഛ ഠ
            ഒ എ ൺ ണ ൻ ഴ ള ശ ഷ
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Maltese",
        layout = """
            q w e r t y u i o p ġ
            a s d f g h j k l ħ `
            z x c v b n m ż ċ
        """.trimIndent(),
        otherLayers = listOf("""
            q w è r t y ù ì ò p ġ
            à s d f g h j k l ħ `
            z x c v b n m ż ċ
        """.trimIndent()),
        moveLayerKeys = listOf("`")
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
        name = "Naskapi (Syllabics)",
        layout = """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᒄ ?
            ᐊ ᐸ ᑕ ᑲ ᒪ ᓇ ᓴ ᔭ ᒐ ᑾ
        """.trimIndent(),
        otherLayers = listOf("""
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐖ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᒄ ?
            ᐛ ᑈ ᑥ ᒂ ᒺ ᓏ ᔄ ᔽ ᒠ ᑾ
        """.trimIndent(), """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᔊ ?
            ᐊ ᔌ ᔍ ᔎ ᒪ ᓇ ᓴ ᔭ ᔏ ᑾ
        """.trimIndent()),
        moveLayerKeys = listOf(":", "ᔋ"),
        hasShift = false
    ),
    Layout(
        name = "Odia (InScript)",
        layout = """
            ◌ृ ◌ୄ ◌ଃ
            ◌ୌ ◌ୈ ◌ା ◌ୀ ◌ୂ ବ ହ ଗ ଦ ଜ ଡ
            ◌ୋ ◌େ ◌୍ ◌ି ◌ୁ ପ ର କ ତ ଚ ଟ
            ◌଼ ◌ଂ ମ ନ ୱ ଲ ସ ଶ ୟ
        """.trimIndent(),
        capsLayer = """
            ଋ ୠ ◌ଃ
            ଔ ଐ ଆ ଈ ଊ ଭ ଙ ଘ ଧ ଝ ଢ
            ଓ ଏ ଅ ଇ ଉ ଫ ଡ଼ ଖ ଥ ଛ ଠ
            ଞ ◌ଁ ଣ ଢ଼ ଵ ଳ ॥ ଷ ଯ
        """.trimIndent(),
        bottomRowKey = zwnjKey
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
        name = "Portuguese",
        layout = """
            ç ´ ` ^ ¨ ~
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ç ´ ` ^ ¨ ~
            q w é r t ý ú í ó p
            á s d f g h j k l
            z x c v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q w è r t ỳ ù ì ò p
            à s d f g h j k l
            z x c v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q w ê r t ŷ û î ô p
            â s d f g h j k l
            z x c v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q w ë r t ÿ ü ï ö p
            ä s d f g h j k l
            z x c v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q w ẽ r t ỹ ũ ĩ õ p
            ã s d f g h j k l
            z x c v b ñ m
        """.trimIndent()),
        moveLayerKeys = "´ ` ^ ¨ ~".split(' ')
    ),
    Layout(
        name = "Punjabi (Gurmukhi) (InScript)",
        layout = """
            ◌ੌ ◌ੈ ◌ਾ ◌ੀ ◌ੂ ਬ ਹ ਗ ਦ ਜ ਡ
            ◌ੋ ◌ੇ ◌੍ ◌ਿ ◌ੁ ਪ ਰ ਕ ਤ ਚ ਟ
            ◌਼ ◌ੰ ਮ ਨ ਵ ਲ ਸ ਸ਼ ਯ
        """.trimIndent(),
        capsLayer = """
            ਔ ਐ ਆ ਈ ਊ ਭ ਙ ਘ ਧ ਝ ਢ
            ਓ ਏ ਅ ਇ ਉ ਫ ੜ ਖ ਥ ਛ ਠ
            ਞ ਂ ਣ ੲ ੳ ਲ਼ ॥ ੱ ?
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Punjabi (Shahmukhi)",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط ݨ
            ق و ع ر ت ے ء ی ہ پ لؕ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠ ن٘
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ,
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
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
        name = "Saanich",
        layout = """
            Á W̱ Ⱥ Ŧ Ⱦ Ṯ Ȼ Í ₭ Ḵ Ḱ
            Q W E R T Y U I O P X̱
            A S D F G H J K L Ƚ Ś
            Z X C V B N M Ṉ Ć
        """.trimIndent(),
        capsLayer = """
            á w̱ ⱥ ŧ ⱦ ṯ ȼ í ꞣ ḵ ḱ
            q w e r t y u i o p x̱
            a s d f g h j k l ƚ ś
            z x c v b n m ṉ ć
        """.trimIndent()
    ),
    Layout(
        name = "Sami (Kildin) (Small)",
        layout = """
            ё ј һ ¯, ӭ ӈ ӓ ъ ҍ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ј һ ¯, ӭ̄ ӈ ӓ̄ ъ ҍ
            ҋ ц ӯ к е̄ ӊ г ш щ з х
            ф ы̄ в а̄ п ҏ о̄ ӆ д ж э̄
            я̄ ч с ӎ ӣ т ь б ю̄
        """.trimIndent()),
        moveLayerKeys = listOf("¯,"),
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
        name = "Shughni (Cyrillic)",
        layout = """
            ё а̄ у̊ ˇ ӗ в̌ ҙ ғ ӯ ъ
            й қ у к е н г ш ҳ з х
            ф ҷ в а п р о л д ж э
            я ч с м и т ӣ б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё а̄ у̊ ˇ ӗ в̌ ҙ ғ ӯ ъ
            й қ у к е н г̌ ш ҳ з х̌
            ф ҷ в̌ а п р о л д̌ ж э
            я ч с м и т̌ ӣ б ю
        """.trimIndent()),
        moveLayerKeys = listOf("ˇ"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Sindhi (Devanagari) (InScript)",
        layout = """
            ◌ॅ ◌ॉ ृ ़ ञ
            ◌ौ ◌ै ◌ा ◌ी ◌ू ब ह ग द ज ड
            ◌ो ◌े ◌् ि ◌ु प र क त च ट
            ◌ँ ◌ं म न व ल स श य
        """.trimIndent(),
        capsLayer = """
            ऍ ऑ ऋ ़ ॿ ञ ॻ ॼ ॾ
            औ ऐ आ ई ऊ भ ङ घ ध झ ढ
            ओ ए अ इ उ फ ऱ ख थ छ ठ
            ◌ः ◌़ ण ऩ ऴ ळ ॥ ष य़
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
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
    Layout(
        name = "Tamil (InScript-like)",
        layout = """
            ◌ௌ ◌ை ◌ா ◌ீ ◌ூ ம ள ங ந ஞ ண
            ◌ோ ◌ே ◌் ◌ி ◌ு ப ர க த ச ட
            ◌ொ ◌ெ ழ ற ன வ ல ஸ ய
        """.trimIndent(),
        capsLayer = """
            ஔ ஐ ஆ ஈ ஊ ம ஹ ங ந ஜ ண
            ஓ ஏ அ இ உ ப ர ஃ த ச க்ஷ
            ஒ எ ழ ற ன வ ல ஷ ஶ
        """.trimIndent()
    ),
    Layout(
        name = "Thai",
        layout = """
            ๅ / _ ภ ถ ◌ุ ◌ึ ค ต จ ข ช
            ๆ ไ ำ พ ะ ◌ั ◌ี ร น ย บ ล
            ฟ ห ก ด เ ◌้ ◌่ า ส ว ง ฃ
            ผ ป แ อ ◌ิ ◌ื ท ม ใ ฝ
        """.trimIndent(),
        capsLayer = """
            + ๑ ๒ ๓ ๔ ◌ู ฿ ๕ ๖ ๗ ๘ ๙
            ๐ " ฎ ฑ ธ ◌ํ ◌๊ ณ ฯ ญ ฐ ,
            ฤ ฆ ฏ โ ฌ ◌็ ◌๋ ษ ศ ซ . ฅ
            ( ) ฉ ฮ ◌ฺ ◌์ ? ฒ ฬ ฦ
        """.trimIndent()
    ),
    Layout(
        name = "Telugu (InScript)",
        layout = """
            ◌ౄ ◌ః ఞ
            ◌ౌ ◌ై ◌ా ◌ీ ◌ూ బ హ గ ద జ డ
            ◌ో ◌ే ◌్ ◌ి ◌ు ప ర క త చ ట
            ◌ొ ◌ె ◌ం మ న వ ల స య
        """.trimIndent(),
        capsLayer = """
            ౠ ◌ః ఞ
            ఔ ఐ ఆ ఈ ఊ భ ఙ ఘ ధ ఝ ఢ
            ఓ ఏ అ ఇ ఉ ఫ ఱ ఖ థ ఛ ఠ
            ఒ ఎ ◌ఁ ణ ◌ృ ఋ ళ శ ష
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
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
        moveLayerKeys = listOf("¯", "^"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Urdu",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط
            ق و ع ر ت ے ء ی ہ پ ذ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ,
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
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
    ),
    Layout(
        name = "Vietnamese",
        layout = """
            â ´ ê ◌̉ ` ~ ư ơ ô .
            q w e r t y u i o p
            a s d f g h j k l đ
            z x c v b n m ă
        """.trimIndent(),
        otherLayers = listOf("""
            ấ ´ ế ◌̉ ` ~ ứ ớ ố .
            q w é r t ý ú í ó p
            á s d f g h j k l đ
            z x c v b n m ắ
        """.trimIndent(), """
            ẩ ´ ể ◌̉ ` ~ ử ở ổ .
            q w ẻ r t ỷ ủ ỉ ỏ p
            ả s d f g h j k l đ
            z x c v b n m ẳ
        """.trimIndent(), """
            ầ ´ ề ◌̉ ` ~ ừ ờ ồ .
            q w è r t ỳ ù ì ò p
            à s d f g h j k l đ
            z x c v b n m ằ
        """.trimIndent(), """
            ẫ ´ ễ ◌̉ ` ~ ữ ỡ ỗ .
            q w ẽ r t ỹ ũ ĩ õ p
            ã s d f g h j k l đ
            z x c v b n m ẵ
        """.trimIndent(), """
            ậ ´ ệ ◌̉ ` ~ ự ợ ộ .
            q w ẹ r t ỵ ụ ị ọ p
            ạ s d f g h j k l đ
            z x c v b n m ặ
        """.trimIndent()),
        moveLayerKeys = "´ ◌̉ ` ~ .".split(' ')
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
