package euler

import org.slf4j.LoggerFactory

trait Slf4jLogger {
  val logger = LoggerFactory.getLogger(this.getClass)
}
