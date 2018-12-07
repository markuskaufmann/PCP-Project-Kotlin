package ch.hslu.pcp.kotlin.typesafebuilders


/**
 * Global helper methods
 * **/
private fun getLineEnding(): String {
    return System.lineSeparator()
}


/**
 * XML Helper classes
 * **/
interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement internal constructor(private val text: String) : Element {

    private fun isEmpty() = text.trim('\n', '\r').isBlank()

    override fun render(builder: StringBuilder, indent: String) {
        if (isEmpty()) {
            return
        }
        val lineEnding = getLineEnding()
        builder.append("$indent$text$lineEnding")
    }
}

class Node(private val nodeName: String) : Element {

    var xmlns: String = "http://hslu.ch/pcp/kotlinbuilderexample"
        set(value) {
            attributes["xmlns"] = value
            field = value
        }
    var encoding: String = Charsets.UTF_8.name()
    private val attributes = LinkedHashMap<String, Any?>()
    private val children = ArrayList<Element>()

    private fun <T : Element> initTag(tag: T, init: (T.() -> Unit)?): T {
        if (init != null) {
            tag.init()
        }
        this.children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        val lineEnding = getLineEnding()
        builder.append("$indent<$nodeName${renderAttributes()}")
        if (this.children.isNotEmpty()) {
            builder.append(">$lineEnding")
            for (c in this.children) {
                c.render(builder, getIndent(indent))
            }
            builder.append("$indent</$nodeName>$lineEnding")
        } else {
            builder.append("/>$lineEnding")
        }
    }

    private fun renderAttributes(): String {
        if (attributes.isEmpty()) {
            return ""
        }
        return " " + attributes.map {
            "${it.key}=\"${escapeQuotes(it.value)}\""
        }.joinToString(" ")
    }

    private fun escapeQuotes(value: Any?): String? {
        val asString = value?.toString() ?: return null
        return asString.replace("\"", "&quot;").replace("'", "&apos;")
    }

    private fun getIndent(indent: String): String {
        return "$indent\t"
    }

    private fun getDocType(): String {
        return "<?xml version=\"1.0\" encoding=\"${this.encoding}\"?>${getLineEnding()}"
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append(getDocType())
        render(sb, "")
        return sb.toString().trim()
    }

    fun text(text: String) {
        this.children.add(TextElement(text))
    }

    fun element(name: String, init: (Node.() -> Unit)? = null): Node = initTag(Node(name), init)

    fun element(name: String, value: String): Node = initTag(Node(name)) {
        text(value)
    }

    operator fun String.invoke(value: String): Node = element(this, value)

    operator fun String.invoke(vararg attributes: Pair<String, Any>, init: (Node.() -> Unit)? = null): Node {
        val e = element(this) {
            attributes(*attributes)
        }
        if (init != null) {
            e.apply(init)
        }
        return e
    }

    fun attribute(name: String, value: Any) {
        attributes[name] = value.toString()
    }

    fun attributes(vararg attrs: Pair<String, Any>) {
        attrs.forEach { attribute(it.first, it.second) }
    }
}

fun xml(root: String, encoding: String? = null, init: (Node.() -> Unit)? = null): Node {
    val node = Node(root)
    if (encoding != null) {
        node.encoding = encoding
    }
    node.attribute("xmlns", node.xmlns)
    if (init != null) {
        node.init()
    }
    return node
}