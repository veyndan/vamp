package com.veyndan.vamp

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class VampRulesetProvider : RuleSetProvider {
    override val ruleSetId: String = "vamp"

    override fun instance(config: Config): RuleSet = RuleSet(
        ruleSetId,
        listOf(
            Vamp(config)
        )
    )
}
