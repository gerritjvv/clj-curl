(ns clj-curl.core
  (:import [com.sun.jna NativeLibrary Function Pointer]
           [clj_curl.JnaInterop MemHandler]))

(defn easy-init ^Pointer
  []
  (.invoke (Function/getFunction "curl" "curl_easy_init") Pointer (to-array [])))

(defn easy-setopt ^Integer
  [^Pointer curl ^Integer i param]
  (.invoke (Function/getFunction "curl" "curl_easy_setopt") Pointer (to-array [curl i param])))

(defn easy-perform ^Integer
  [^Pointer curl]
  (.invoke (Function/getFunction "curl" "curl_easy_perform") Pointer (to-array [curl])))
