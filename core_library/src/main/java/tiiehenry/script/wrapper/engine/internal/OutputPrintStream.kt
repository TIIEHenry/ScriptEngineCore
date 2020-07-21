package tiiehenry.script.wrapper.engine.internal

import java.io.IOException
import java.io.InterruptedIOException
import java.io.OutputStream
import java.io.PrintStream
import java.util.*

abstract class OutputPrintStream(out: OutputStream, autoFlush: Boolean = true) : PrintStream(out, autoFlush), Appendable {

//    init {
//        formatter= Formatter(this)
//    }
    abstract val formatter: Formatter
    abstract fun onPrint(s: String)
    abstract fun onNewLine()

    /* Methods that do not terminate lines */
    /**
     * Prints a boolean value.  The string produced by `[ ][java.lang.String.valueOf]` is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      b   The `boolean` to be printed
     */
    override fun print(b: Boolean) {
        onPrint(if (b) "true" else "false")
    }

    /**
     * Prints a character.  The character is translated into one or more bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      c   The `char` to be printed
     */
    override fun print(c: Char) {
        onPrint(c.toString())
    }

    /**
     * Prints an integer.  The string produced by `[ ][java.lang.String.valueOf]` is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      i   The `int` to be printed
     * @see java.lang.Integer.toString
     */
    override fun print(i: Int) {
        onPrint(i.toString())
    }

    /**
     * Prints a long integer.  The string produced by `[ ][java.lang.String.valueOf]` is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      l   The `long` to be printed
     * @see java.lang.Long.toString
     */
    override fun print(l: Long) {
        onPrint(l.toString())
    }

    /**
     * Prints a floating-point number.  The string produced by `[ ][java.lang.String.valueOf]` is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      f   The `float` to be printed
     * @see java.lang.Float.toString
     */
    override fun print(f: Float) {
        onPrint(f.toString())
    }

    /**
     * Prints a double-precision floating-point number.  The string produced by
     * `[java.lang.String.valueOf]` is translated into
     * bytes according to the platform's default character encoding, and these
     * bytes are written in exactly the manner of the `[ ][.write]` method.
     *
     * @param      d   The `double` to be printed
     * @see java.lang.Double.toString
     */
    override fun print(d: Double) {
        onPrint(d.toString())
    }

    /**
     * Prints an array of characters.  The characters are converted into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      s   The array of chars to be printed
     *
     * @throws  NullPointerException  If `s` is `null`
     */
    override fun print(s: CharArray) {
        onPrint(s.toString())
    }

    /**
     * Prints a string.  If the argument is `null` then the string
     * `"null"` is printed.  Otherwise, the string's characters are
     * converted into bytes according to the platform's default character
     * encoding, and these bytes are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      s   The `String` to be printed
     */
    override fun print(s: String) {
        onPrint(s)
    }

    /**
     * Prints an object.  The string produced by the `[ ][java.lang.String.valueOf]` method is translated into bytes
     * according to the platform's default character encoding, and these bytes
     * are written in exactly the manner of the
     * `[.write]` method.
     *
     * @param      obj   The `Object` to be printed
     * @see java.lang.Object.toString
     */
    override fun print(obj: Any?) {
        onPrint((obj ?: "null").toString())
    }


    /* Methods that do terminate lines */

    /* Methods that do terminate lines */
    /**
     * Terminates the current line by writing the line separator string.  The
     * line separator string is defined by the system property
     * `line.separator`, and is not necessarily a single newline
     * character (`'\n'`).
     */
    override fun println() {
        onNewLine()
    }

    /**
     * Prints a boolean and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `boolean` to be printed
     */
    override fun println(x: Boolean) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints a character and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `char` to be printed.
     */
    override fun println(x: Char) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints an integer and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `int` to be printed.
     */
    override fun println(x: Int) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints a long and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  a The `long` to be printed.
     */
    override fun println(x: Long) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints a float and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `float` to be printed.
     */
    override fun println(x: Float) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints a double and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `double` to be printed.
     */
    override fun println(x: Double) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints an array of characters and then terminate the line.  This method
     * behaves as though it invokes `[.print]` and
     * then `[.println]`.
     *
     * @param x  an array of chars to print.
     */
    override fun println(x: CharArray?) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints a String and then terminate the line.  This method behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `String` to be printed.
     */
    override fun println(x: String?) {
        synchronized(this) {
            print(x)
            onNewLine()
        }
    }

    /**
     * Prints an Object and then terminate the line.  This method calls
     * at first String.valueOf(x) to get the printed object's string value,
     * then behaves as
     * though it invokes `[.print]` and then
     * `[.println]`.
     *
     * @param x  The `Object` to be printed.
     */
    override fun println(x: Any) {
        val s = x.toString()
        synchronized(this) {
            print(s)
            onNewLine()
        }
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     *
     *  An invocation of this method of the form <tt>out.printf(format,
     * args)</tt> behaves in exactly the same way as the invocation
     *
     * <pre>
     * out.format(format, args) </pre>
     *
     * @param  format
     * A format string as described in [Format string syntax](../util/Formatter.html#syntax)
     *
     * @param  args
     * Arguments referenced by the format specifiers in the format
     * string.  If there are more arguments than format specifiers, the
     * extra arguments are ignored.  The number of arguments is
     * variable and may be zero.  The maximum number of arguments is
     * limited by the maximum dimension of a Java array as defined by
     * <cite>The Java Virtual Machine Specification</cite>.
     * The behaviour on a
     * <tt>null</tt> argument depends on the [conversion](../util/Formatter.html#syntax).
     *
     * @throws  java.util.IllegalFormatException
     * If a format string contains an illegal syntax, a format
     * specifier that is incompatible with the given arguments,
     * insufficient arguments given the format string, or other
     * illegal conditions.  For specification of all possible
     * formatting errors, see the [Details](../util/Formatter.html#detail) section of the
     * formatter class specification.
     *
     * @throws  NullPointerException
     * If the <tt>format</tt> is <tt>null</tt>
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun printf(format: String, vararg args: Any): PrintStream {
        return format(format, *args)
    }

    /**
     * A convenience method to write a formatted string to this output stream
     * using the specified format string and arguments.
     *
     *
     *  An invocation of this method of the form <tt>out.printf(l, format,
     * args)</tt> behaves in exactly the same way as the invocation
     *
     * <pre>
     * out.format(l, format, args) </pre>
     *
     * @param  l
     * The [locale][java.util.Locale] to apply during
     * formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
     * is applied.
     *
     * @param  format
     * A format string as described in [Format string syntax](../util/Formatter.html#syntax)
     *
     * @param  args
     * Arguments referenced by the format specifiers in the format
     * string.  If there are more arguments than format specifiers, the
     * extra arguments are ignored.  The number of arguments is
     * variable and may be zero.  The maximum number of arguments is
     * limited by the maximum dimension of a Java array as defined by
     * <cite>The Java Virtual Machine Specification</cite>.
     * The behaviour on a
     * <tt>null</tt> argument depends on the [conversion](../util/Formatter.html#syntax).
     *
     * @throws  java.util.IllegalFormatException
     * If a format string contains an illegal syntax, a format
     * specifier that is incompatible with the given arguments,
     * insufficient arguments given the format string, or other
     * illegal conditions.  For specification of all possible
     * formatting errors, see the [Details](../util/Formatter.html#detail) section of the
     * formatter class specification.
     *
     * @throws  NullPointerException
     * If the <tt>format</tt> is <tt>null</tt>
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun printf(l: Locale, format: String, vararg args: Any): PrintStream {
        return format(l, format, *args)
    }

    /**
     * Writes a formatted string to this output stream using the specified
     * format string and arguments.
     *
     *
     *  The locale always used is the one returned by [ ][java.util.Locale.getDefault], regardless of any
     * previous invocations of other formatting methods on this object.
     *
     * @param  format
     * A format string as described in [Format string syntax](../util/Formatter.html#syntax)
     *
     * @param  args
     * Arguments referenced by the format specifiers in the format
     * string.  If there are more arguments than format specifiers, the
     * extra arguments are ignored.  The number of arguments is
     * variable and may be zero.  The maximum number of arguments is
     * limited by the maximum dimension of a Java array as defined by
     * <cite>The Java Virtual Machine Specification</cite>.
     * The behaviour on a
     * <tt>null</tt> argument depends on the [conversion](../util/Formatter.html#syntax).
     *
     * @throws  java.util.IllegalFormatException
     * If a format string contains an illegal syntax, a format
     * specifier that is incompatible with the given arguments,
     * insufficient arguments given the format string, or other
     * illegal conditions.  For specification of all possible
     * formatting errors, see the [Details](../util/Formatter.html#detail) section of the
     * formatter class specification.
     *
     * @throws  NullPointerException
     * If the <tt>format</tt> is <tt>null</tt>
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun format(format: String, vararg args: Any): OutputPrintStream {
        try {
            synchronized(this) {
                formatter.format(Locale.getDefault(), format, *args)
            }
        } catch (x: InterruptedIOException) {
            Thread.currentThread().interrupt()
        } catch (x: IOException) {
        }
        return this
    }

    /**
     * Writes a formatted string to this output stream using the specified
     * format string and arguments.
     *
     * @param  l
     * The [locale][java.util.Locale] to apply during
     * formatting.  If <tt>l</tt> is <tt>null</tt> then no localization
     * is applied.
     *
     * @param  format
     * A format string as described in [Format string syntax](../util/Formatter.html#syntax)
     *
     * @param  args
     * Arguments referenced by the format specifiers in the format
     * string.  If there are more arguments than format specifiers, the
     * extra arguments are ignored.  The number of arguments is
     * variable and may be zero.  The maximum number of arguments is
     * limited by the maximum dimension of a Java array as defined by
     * <cite>The Java Virtual Machine Specification</cite>.
     * The behaviour on a
     * <tt>null</tt> argument depends on the [conversion](../util/Formatter.html#syntax).
     *
     * @throws  java.util.IllegalFormatException
     * If a format string contains an illegal syntax, a format
     * specifier that is incompatible with the given arguments,
     * insufficient arguments given the format string, or other
     * illegal conditions.  For specification of all possible
     * formatting errors, see the [Details](../util/Formatter.html#detail) section of the
     * formatter class specification.
     *
     * @throws  NullPointerException
     * If the <tt>format</tt> is <tt>null</tt>
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun format(l: Locale, format: String, vararg args: Any): PrintStream {
        try {
            synchronized(this) {
                formatter.format(l, format, *args)
            }
        } catch (x: InterruptedIOException) {
            Thread.currentThread().interrupt()
        } catch (x: IOException) {
        }
        return this
    }

    /**
     * Appends the specified character sequence to this output stream.
     *
     *
     *  An invocation of this method of the form <tt>out.append(csq)</tt>
     * behaves in exactly the same way as the invocation
     *
     * <pre>
     * out.print(csq.toString()) </pre>
     *
     *
     *  Depending on the specification of <tt>toString</tt> for the
     * character sequence <tt>csq</tt>, the entire sequence may not be
     * appended.  For instance, invoking then <tt>toString</tt> method of a
     * character buffer will return a subsequence whose content depends upon
     * the buffer's position and limit.
     *
     * @param  csq
     * The character sequence to append.  If <tt>csq</tt> is
     * <tt>null</tt>, then the four characters <tt>"null"</tt> are
     * appended to this output stream.
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun append(csq: CharSequence?): PrintStream? {
        if (csq == null) print("null") else (csq.toString())
        return this
    }

    /**
     * Appends a subsequence of the specified character sequence to this output
     * stream.
     *
     *
     *  An invocation of this method of the form <tt>out.append(csq, start,
     * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
     * exactly the same way as the invocation
     *
     * <pre>
     * out.print(csq.subSequence(start, end).toString()) </pre>
     *
     * @param  csq
     * The character sequence from which a subsequence will be
     * appended.  If <tt>csq</tt> is <tt>null</tt>, then characters
     * will be appended as if <tt>csq</tt> contained the four
     * characters <tt>"null"</tt>.
     *
     * @param  start
     * The index of the first character in the subsequence
     *
     * @param  end
     * The index of the character following the last character in the
     * subsequence
     *
     * @return  This output stream
     *
     * @throws  IndexOutOfBoundsException
     * If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
     * is greater than <tt>end</tt>, or <tt>end</tt> is greater than
     * <tt>csq.length()</tt>
     *
     * @since  1.5
     */
    override fun append(csq: CharSequence?, start: Int, end: Int): PrintStream? {
        val cs = csq ?: "null"
        print(cs.subSequence(start, end).toString())
        return this
    }

    /**
     * Appends the specified character to this output stream.
     *
     *
     *  An invocation of this method of the form <tt>out.append(c)</tt>
     * behaves in exactly the same way as the invocation
     *
     * <pre>
     * out.print(c) </pre>
     *
     * @param  c
     * The 16-bit character to append
     *
     * @return  This output stream
     *
     * @since  1.5
     */
    override fun append(c: Char): PrintStream? {
        print(c)
        return this
    }
}