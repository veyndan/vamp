package com.veyndan.vamp

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.rules.setupKotlinEnvironment
import io.gitlab.arturbosch.detekt.test.compileAndLintWithContext
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class VampTest : Spek({
    setupKotlinEnvironment()

    val env: KotlinCoreEnvironment by memoized()
    val rule by memoized { Vamp(Config.empty) }

    describe("Vamp rule") {

        it("list0") {
            val code = """
                import com.veyndan.vamp.Min

                fun foo(): @Min(10) Int {
                    val strings = listOf("Hello", "World")
                    return strings.size
                }
            """
            rule.compileAndLintWithContext(env, code)
//            assertThat(rule.compileAndLintWithContext(env, code))
//                .hasSourceLocation(0, 1)
        }
    }

//    @Test
//    fun `minus0`() {
//        val findings = Vamp().lint("""
//            import com.veyndan.vamp.Min
//
//            fun foo(): @Min(10) Int {
//                return 20 - 11
//            }
//        """)
//
//        assertThat(findings).hasSize(1)
//    }
//
//    @Test
//    fun `minus1`() {
//        val findings = Vamp().lint("""
//            import com.veyndan.vamp.Min
//
//            fun foo(): @Min(10) Int {
//                return 20 - 9
//            }
//        """)
//
//        assertThat(findings).isEmpty()
//    }
//
//    @Test
//    fun `minus2`() {
//        val findings = Vamp().lint("""
//            import com.veyndan.vamp.Min
//
//            fun foo(): @Min(10) Int = 20 - 11
//        """)
//
//        assertThat(findings).hasSize(1)
//    }
//
//    @Test
//    fun `minus3`() {
//        val findings = Vamp().lint("""
//            import com.veyndan.vamp.Min
//
//            fun foo(): @Min(10) Int = 20 - 9
//        """)
//
//        assertThat(findings).isEmpty()
//    }
})
