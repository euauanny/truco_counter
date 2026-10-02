package com.example.prova_auanny

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TrucoFlowTest {
    @Test fun vitoriasHistoricoEReinicio() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.btNos9)).perform(click())
            onView(withId(R.id.btNos6)).perform(click())
            onView(withId(R.id.tvPontosNos)).check(matches(withText("0")))
            onView(withId(R.id.btEles12)).perform(click())
            onView(withId(R.id.tvPontosEles)).check(matches(withText("0")))
            onView(withId(R.id.btHistorico)).perform(click())
            onView(withId(R.id.tvVitoriasNos)).check(matches(withText("Nós: 1")))
            onView(withId(R.id.tvVitoriasEles)).check(matches(withText("Eles: 1")))
            onView(withId(R.id.btVoltar)).perform(click())
            onView(withId(R.id.btNos3)).perform(click())
            onView(withId(R.id.btEles6)).perform(click())
            onView(withId(R.id.btZerar)).perform(click())
            onView(withId(R.id.tvPontosNos)).check(matches(withText("0")))
            onView(withId(R.id.tvPontosEles)).check(matches(withText("0")))
            onView(withId(R.id.btHistorico)).perform(click())
            onView(withId(R.id.tvVitoriasNos)).check(matches(withText("Nós: 0")))
            onView(withId(R.id.tvVitoriasEles)).check(matches(withText("Eles: 0")))
            pressBack()
        }
    }

    @Test fun recriarTelaPreservaPontosEVitorias() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            onView(withId(R.id.btNos12)).perform(click())
            onView(withId(R.id.btNos3)).perform(click())
            onView(withId(R.id.btEles9)).perform(click())
            scenario.recreate()
            onView(withId(R.id.tvPontosNos)).check(matches(withText("3")))
            onView(withId(R.id.tvPontosEles)).check(matches(withText("9")))
            onView(withId(R.id.btHistorico)).perform(click())
            onView(withId(R.id.tvVitoriasNos)).check(matches(withText("Nós: 1")))
            onView(withId(R.id.tvVitoriasEles)).check(matches(withText("Eles: 0")))
            pressBack()
            onView(withId(R.id.tvPontosNos)).check(matches(withText("3")))
        }
    }
}
