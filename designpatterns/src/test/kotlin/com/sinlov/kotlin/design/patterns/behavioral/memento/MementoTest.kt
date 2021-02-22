package com.sinlov.kotlin.design.patterns.behavioral.memento

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MementoTest : StringSpec({

    "memento test" {
        val originator = Originator()
        val careTaker = CareTaker()

        originator.state = "state #1"
        originator.state = "state #2"
        careTaker.add(originator.saveState2Memento())
        originator.state = "state #3"
        careTaker.add(originator.saveState2Memento())
        originator.state = "state #4"

//        println("originator.state = ${originator.state}")
        originator.state shouldBe "state #4"
        originator.getStateFromMemento(careTaker.get(0))
//        println("originator.state = ${originator.state}")
        originator.state shouldBe "state #2"
        originator.getStateFromMemento(careTaker.get(1))
//        println("originator.state = ${originator.state}")
        originator.state shouldBe "state #3"
    }

})
