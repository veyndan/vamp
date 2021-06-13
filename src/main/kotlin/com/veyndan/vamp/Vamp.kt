package com.veyndan.vamp

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.descriptors.CallableDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.ValueArgument
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe

class Vamp(config: Config = Config.empty) : Rule(config) {
    override val issue = Issue(
        "Vamp",
        Severity.Defect,
        "Vamp is amazing. Don't fuck with it.",
        Debt.FIVE_MINS,
    )

    class ListOfComp(resolvedCall: ResolvedCall<out CallableDescriptor>) : List<ValueArgument> by resolvedCall.valueArgumentsByIndex!!.single().arguments

    private val something: Map<FqName, (ResolvedCall<out CallableDescriptor>) -> ListOfComp<*>> = mapOf(
        KotlinBuiltIns.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier("listOf")) to { resolvedCall ->
            ListOfComp(resolvedCall)
        },
    )

    override fun visitNamedFunction(function: KtNamedFunction) {
        super.visitNamedFunction(function)

        val listOfExpression = (function.bodyBlockExpression!!.statements.first() as KtProperty).initializer!! as KtCallExpression
        val listOfResolvedCall = listOfExpression.getResolvedCall(bindingContext)!!

        println(something.getValue(listOfResolvedCall.resultingDescriptor.fqNameSafe).invoke(listOfResolvedCall))

//        check(function.children.size == 3)
//        val functionReturnType = function.typeReference!!
//        val functionBodyReturnedExpression = when {
//            function.hasBlockBody() -> {
//                val statements = function.bodyBlockExpression!!.statements
//                (statements.single() as KtReturnExpression).returnedExpression!! as KtBinaryExpression
//            }
//            else -> function.bodyExpression!! as KtBinaryExpression
//        }
//
//        val minFunctionAnnotation = functionReturnType.annotationEntries.single()
//
//        check(minFunctionAnnotation.children.size == 2)
//        check(minFunctionAnnotation.children[0].textMatches("Min"))
//        val minValueFromFunctionAnnotation = (minFunctionAnnotation.children[1] as KtValueArgumentList).let {
//            check(it.arguments.size == 1)
//            it.arguments[0].let { minValueArgument ->
//                check(minValueArgument.children.size == 1)
//                (minValueArgument.children[0] as KtConstantExpression).text.toInt()
//            }
//        }
//
//        check(functionReturnType.typeElement!!.text == "Int")
//
//        check(functionBodyReturnedExpression.operationToken.toString() == "MINUS")
//
//        println(functionBodyReturnedExpression.operationReference.isConventionOperator())
//        println(functionBodyReturnedExpression.operationReference.getReferencedNameElement())
//        println(functionBodyReturnedExpression.operationReference.operationSignTokenType)
//
//        val functionBodyReturnedExpressionLeft = (functionBodyReturnedExpression.left as KtConstantExpression).text.toInt()
//        val functionBodyReturnedExpressionRight = (functionBodyReturnedExpression.right as KtConstantExpression).text.toInt()
//
////        DescriptorUtils.getContainingModule(function.containingNonLocalDeclaration()!!)
//
////        ConstantExpressionEvaluator(functionBody.statements.single())
//
//        val functionBodyReturnedExpressionFunction = functionBodyReturnedExpressionLeft::class.functions
//            .single { it.name == "minus" && it.parameters[1].type.toString() == functionBodyReturnedExpressionRight::class.qualifiedName }
//
//        functionBodyReturnedExpressionFunction.parameters.forEach { println(it) }
//
////        println(functionBodyReturnedExpressionFunction.call())
//
//        if (functionBodyReturnedExpressionLeft - functionBodyReturnedExpressionRight < minValueFromFunctionAnnotation) {
//            report(CodeSmell(issue, Entity.from(function), "$functionBodyReturnedExpressionLeft - $functionBodyReturnedExpressionRight < $minValueFromFunctionAnnotation"))
//        }
    }
}

// TODO!!! You have to comment out the detekt cli dependency and then run it and then uncomment it again and run it everytime you want to run Vamp.
