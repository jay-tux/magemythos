# ANTLR Post-Processing

## Step 1: Java -> Kotlin
I recommend using the CTRL-ALT-SHIFT-K shortcut to convert the Java code to Kotlin on the generated JAVA files.
This is builtin in Intellij and Android Studio.

## Step 2: Fixing some compilation errors
1. The `init` block after `tokenNames` in both `MMLexer.kt` and `MMParser.kt`: replace
   ```kt
   val tokenNames: Array<String>

   init {
       tokenNames = arrayOfNulls(_SYMBOLIC_NAMES.size)
       for (i in tokenNames.indices) {
           tokenNames[i] = VOCABULARY.getLiteralName(i)
           if (tokenNames[i] == null) {
               tokenNames[i] = VOCABULARY.getSymbolicName(i)
           }
           if (tokenNames[i] == null) {
               tokenNames[i] = "<INVALID>"
           }
       }
   }
   ```
   with
   ```kt
   val tokenNames = _SYMBOLIC_NAMES.indices.map {
        VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
   }.toTypedArray()
   ```
   
2. In the `init` block at the end of both files, replace
   ```kt
    _decisionToDFA = arrayOfNulls(_ATN.numberOfDecisions)
    for (i in 0 until _ATN.numberOfDecisions) {
        _decisionToDFA[i] = DFA(_ATN.getDecisionState(i), i)
    }
   ```
   with
   ```kt
    _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
        DFA(_ATN.getDecisionState(it), it)
    }.toTypedArray()
   ```

## Step 4: Compilation errors in MMParser.kt
Some `when` statements in `MMParser.kt` are missing an `else` branch.
You can just add an empty one, no problem.

Additionally, some fields wrongly have a `List<T>` type. 
They should be made `MutableList<T?>` instead.