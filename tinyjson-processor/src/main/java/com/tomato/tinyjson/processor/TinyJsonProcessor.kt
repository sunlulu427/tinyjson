package com.tomato.tinyjson.processor

import com.tomato.tinyjson.annotations.Description
import com.tomato.tinyjson.annotations.Serialized
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement

class TinyJsonProcessor : AbstractProcessor() {

    companion object {
        private const val TAG = "TinyJsonProcessor >>> "
    }

    private var consumed = false

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Serialized::class.java.canonicalName,
            Description::class.java.canonicalName
        )
    }


    override fun process(elements: MutableSet<out TypeElement>?,
                         roundEnv: RoundEnvironment?
    ): Boolean {
        if (roundEnv?.processingOver() != false || elements == null) {
            return false;
        }
        println(TAG + "process start")

        val serializedElement = roundEnv
            .getElementsAnnotatedWith(Serialized::class.java)
            .firstOrNull() as? VariableElement

        if (serializedElement != null && !consumed) {
            consumed = true
            val classInfo = """
            package com.tomato.livecore.tests;
            
            
            public class GeneratedClass {
            
                public int ${serializedElement.simpleName} = ${serializedElement.constantValue};
                
                public String name = "${serializedElement.simpleName}";
            }
           
        """.trimIndent()

            try {
                val source = processingEnv.filer.createSourceFile(
                    "com.tomato.livecore.tests.GeneratedClass"
                )
                val writer = source.openWriter()
                writer.write(classInfo)
                writer.flush()
                writer.close()
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }

        return true
    }
}