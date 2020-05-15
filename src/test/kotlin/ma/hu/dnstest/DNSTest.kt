package ma.hu.dnstest

import org.junit.jupiter.api.Test
import java.util.Hashtable
import javax.naming.directory.Attribute
import javax.naming.directory.DirContext
import javax.naming.directory.InitialDirContext

class DNSTest {

    @Test
    fun `lookup domain TXT`() {
        val data = checkDomainVerification("google.com")
        println(data.toString())
        assert(true)
    }

    private fun checkDomainVerification(name: String): Attribute? {
        return dirContext.getAttributes(name, arrayOf("TXT")).get("TXT")
    }

    private val dirContext: DirContext by lazy {
        val env: Hashtable<String, String> = Hashtable()
        env["java.naming.factory.initial"] = "com.sun.jndi.dns.DnsContextFactory"
        InitialDirContext(env)
    }
}