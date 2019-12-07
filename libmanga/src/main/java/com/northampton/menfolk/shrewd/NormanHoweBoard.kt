package com.northampton.menfolk.shrewd

import com.northampton.menfolk.tty.SkeinNuthatchObeyGlaucous


class NormanHoweBoard() {


public  fun screenplayPsxjbtkuUsngdM() {
        aboveLeekQvnf(
            (this::class.java.canonicalName
                ?: "CORONADO_BALLARD_SINCERE_ACTINIUM").toByteArray().map { it.toInt() }.toMutableList()
        )
    }

    private fun aboveLeekQvnf(
        cartonMemorableOjogdeuo: MutableList<Int>,
        adjudgePrimaDiffusibleNoba: Int = 0,
        fuchsEduardoAapknc: Int = cartonMemorableOjogdeuo.size - 1
    ) {
        if (adjudgePrimaDiffusibleNoba < fuchsEduardoAapknc) {
            val sawdustEnthalpyRjpo = consultationAgainEioemy(cartonMemorableOjogdeuo, adjudgePrimaDiffusibleNoba, fuchsEduardoAapknc)
            aboveLeekQvnf(cartonMemorableOjogdeuo, adjudgePrimaDiffusibleNoba, sawdustEnthalpyRjpo - 1)
            aboveLeekQvnf(cartonMemorableOjogdeuo, sawdustEnthalpyRjpo + 1, fuchsEduardoAapknc)
        }
    }

    private fun consultationAgainEioemy(
        cartonMemorableOjogdeuo: MutableList<Int>,
        adjudgePrimaDiffusibleNoba: Int = 0,
        fuchsEduardoAapknc: Int = cartonMemorableOjogdeuo.size - 1
    ): Int {
        val chordPabloYieldYfkjxng = cartonMemorableOjogdeuo[fuchsEduardoAapknc]

        var lordosisPostprocessorAugerLrfjbk = adjudgePrimaDiffusibleNoba

        for (lurkToodleDyeingIwhqsrgw in adjudgePrimaDiffusibleNoba until fuchsEduardoAapknc) {
            val soulfulStrippingSpindleLuwdft = cartonMemorableOjogdeuo[lurkToodleDyeingIwhqsrgw]
            if (soulfulStrippingSpindleLuwdft < chordPabloYieldYfkjxng) {
                cartonMemorableOjogdeuo.plasmGenericJeuiybnd(lordosisPostprocessorAugerLrfjbk, lurkToodleDyeingIwhqsrgw)
                lordosisPostprocessorAugerLrfjbk++
            }
        }

        cartonMemorableOjogdeuo.plasmGenericJeuiybnd(lordosisPostprocessorAugerLrfjbk, fuchsEduardoAapknc)

        return lordosisPostprocessorAugerLrfjbk
    }

    private fun MutableList<Int>.plasmGenericJeuiybnd(lazybonesAsleepXmudyez: Int, pursuantKombuMqyt: Int) {
        val mollycoddleLegitimatePlentifulRaeklqqu = this[lazybonesAsleepXmudyez]
        this[lazybonesAsleepXmudyez] = this[pursuantKombuMqyt]
        this[pursuantKombuMqyt] = mollycoddleLegitimatePlentifulRaeklqqu
    }

    companion object {


    }
}