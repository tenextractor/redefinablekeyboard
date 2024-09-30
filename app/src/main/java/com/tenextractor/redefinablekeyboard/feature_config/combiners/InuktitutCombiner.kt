package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.xInY
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object InuktitutCombiner: Combiner {
    private val vowels = mapOf(
        'ᐃ' to 0 /*i*/, 'ᐄ' to 1 /*ii*/,
        'ᐅ' to 2 /*u*/, 'ᐆ' to 3 /*uu*/,
        'ᐁ' to 4 /*ai*/, 'ᐊ' to 5 /*a*/, 'ᐋ' to 6 /*aa*/
    )

    private val finalsToSyllables = mapOf(
        //any consonant X to Xi, Xii, Xu, Xuu, Xai, Xa, Xaa respectively
        "ᑉ" to listOf('ᐱ', 'ᐲ', 'ᐳ', 'ᐴ', 'ᐯ', 'ᐸ', 'ᐹ'), //p
        "ᑦ" to listOf('ᑎ', 'ᑏ', 'ᑐ', 'ᑑ', 'ᑌ', 'ᑕ', 'ᑖ'), //t
        "ᒃ" to listOf('ᑭ', 'ᑮ', 'ᑯ', 'ᑰ', 'ᑫ', 'ᑲ', 'ᑳ'), //k
        "ᕻ" to listOf('ᕵ', 'ᕶ', 'ᕷ', 'ᕸ', 'ᕴ', 'ᕹ', 'ᕺ'), //nunavik h
        "ᒡ" to listOf('ᒋ', 'ᒌ', 'ᒍ', 'ᒎ', 'ᒉ', 'ᒐ', 'ᒑ'), //g (c in unicode)
        "ᒻ" to listOf('ᒥ', 'ᒦ', 'ᒧ', 'ᒨ', 'ᒣ', 'ᒪ', 'ᒫ'), //m
        "ᓐ" to listOf('ᓂ', 'ᓃ', 'ᓄ', 'ᓅ', 'ᓀ', 'ᓇ', 'ᓈ'), //n
        "ᔅ" to listOf('ᓯ', 'ᓰ', 'ᓱ', 'ᓲ', 'ᓭ', 'ᓴ', 'ᓵ'), //s
        "\uD806\uDEBA" to listOf("\uD806\uDEB6", "\uD806\uDEB7", "\uD806\uDEB8", "\uD806\uDEB9",
            "\uD806\uDEBAᐃ", "\uD806\uDEBA", "\uD806\uDEBB"), //š (nattilik shr in unicode)
        "\uD806\uDEB4" to listOf("\uD806\uDEB0", "\uD806\uDEB1", "\uD806\uDEB2", "\uD806\uDEB3",
            "\uD806\uDEB4ᐃ", "\uD806\uDEB4", "\uD806\uDEB5"), //nattilik h
        "ᓪ" to listOf('ᓕ', 'ᓖ', 'ᓗ', 'ᓘ', 'ᓓ', 'ᓚ', 'ᓛ'), //l
        "ᔾ" to listOf('ᔨ', 'ᔩ', 'ᔪ', 'ᔫ', 'ᔦ', 'ᔭ', 'ᔮ'), //j (y in unicode)
        //"ᑦᔾ" to listOf("ᑦᔨ", "ᑦᔩ", "ᑦᔪ", "ᑦᔫ", "ᑦᔦ", "ᑦᔭ", "ᑦᔮ"), //jj
        "ᖮ" to listOf('ᖨ', 'ᖩ', 'ᖪ', 'ᖫ', "ᖬᐃ", 'ᖬ', 'ᖭ'), //ř (th-cree th in unicode)
        "ᕝ" to listOf('ᕕ', 'ᕖ', 'ᕗ', 'ᕘ', 'ᕓ', 'ᕙ', 'ᕚ'), //v (f in unicode)
        "ᕐ" to listOf('ᕆ', 'ᕇ', 'ᕈ', 'ᕉ', 'ᕂ', 'ᕋ', 'ᕌ'), //r
        "ᖅ" to listOf('ᕿ', 'ᖀ', 'ᖁ', 'ᖂ', 'ᙯ', 'ᖃ', 'ᖄ'), //q
        //"ᖅᒃ" to listOf("ᖅᑭ", "ᖅᑮ", "ᖅᑯ", "ᖅᑰ", "ᖅᑫ", "ᖅᑲ", "ᖅᑳ"), //qq
        "ᖕ" to listOf('ᖏ', 'ᖐ', 'ᖑ', 'ᖒ', 'ᙰ', 'ᖓ', 'ᖔ'), //ng
        "ᖖ" to listOf('ᙱ', 'ᙲ', 'ᙳ', 'ᙴ', 'ᙵ', 'ᙵ', 'ᙶ'), //nng
        "ᖦ" to listOf('ᖠ', 'ᖡ', 'ᖢ', 'ᖢ', "ᖤᐃ", 'ᖤ', 'ᖥ'), //lh
    )

    private val singleToDouble = mapOf(
        'ᔾ' to "ᑦᔾ" /*j*/, 'ᖅ' to "ᖅᒃ" /*q*/, 'ᖕ' to "ᖖ" /*ng*/
    )

    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        val keyText = key.text[0]

        if (charBefore != null) if (charBefore.isNotEmpty()) {
            if (singleToDouble.containsKey(charBefore[0])) if (keyText == charBefore[0]) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(singleToDouble[charBefore[0]], 1)
                return
            }

            if (finalsToSyllables.containsKey(charBefore[0].toString()))
                if (vowels.containsKey(keyText)) {
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                    inputConnection.commitText(
                        finalsToSyllables[charBefore[0].toString()]!![vowels[keyText]!!].toString(),
                        1)
                    return
            }
        }
        DefaultCombiner.combine(key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        DefaultCombiner.delete(imeService, inputConnection)
    }
}