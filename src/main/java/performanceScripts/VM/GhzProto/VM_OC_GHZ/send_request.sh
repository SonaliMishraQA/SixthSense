#!/bin/bash

# Define the duration in seconds (24 hours)
duration=$((24 * 60 * 60))

# Define the interval between requests (1 minute)
interval=60

# Calculate the number of iterations
iterations=$((duration / interval))

# Loop through each iteration
for ((i=0; i<iterations; i++)); do
    # Loop through each string from 1 to 4000
    for ((j=1; j<=4000; j++)); do
        # Form the request payload with the dynamic string
       #echo "{\"name\": \"service1$j\"}" > request.json

        # Send the request using ghz
   
ghz --insecure --async  \
  --proto ./metrics_service.proto \
  --call opencensus.proto.agent.metrics.v1.MetricsService/Export \
  -c 1 -o output.log --stream-call-count=1  \
  -m "{\"Authentication\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZWFtSWQiOiJkMTViMGU0Yi0xMmRhLTQyNDctYmEzNy00YWU4MDM5YzFiOTIiLCJiaWxsaW5nX2lkIjoiOThjZjE2NDMtYTFmYS00OTgzLWFkNTItYjY3NGI1NjZlMTE1IiwiaWF0IjoxNzExMzY1MDU2LCJhdWQiOiJvYXAiLCJpc3MiOiJzaXh0aC1zZW5zLWF1dGgifQ.LVt2OhvNWlIflCSpzM-UNS1PdvXNmqPag8R76z_WYgs\" , \"TeamID\":\"d15b0e4b-12da-4247-ba37-4ae8039c1b92\"}"  \
  -d '
  [{
    "node": {
        "identifier": {
            "host_name": "{'name':'VMData','teamID':'d15b0e4b-12da-4247-ba37-4ae8039c1b92','type':'V'}"
        
    }
},
    "metrics": [
        {
            "metric_descriptor": {
                "name": "node_cpu_seconds_total",
                "description": "Seconds the CPUs spent in each mode.",
                "type": "CUMULATIVE_DOUBLE",
                "label_keys": [
                    {
                        "key": "cpu"
                    },
                    {
                        "key": "mode"
                    }
                ]
            },
            "timeseries": [
                {
                    "start_timestamp": "{{.Timestamp}}",
                    "label_values": [
                        {
                            "value": "0",
                            "hasValue": true
                        },
                        {
                            "value": "system",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",
                            "double_value": 24951.38
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",
                    "label_values": [
                        {
                            "value": "0",
                            "hasValue": true
                        },
                        {
                            "value": "user",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",
                            "double_value": 172304.61
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",
                    "label_values": [
                        {
                            "value": "0",
                            "hasValue": true
                        },
                        {
                            "value": "nice",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",
                            "double_value": 50234.20
                        }
                    ]
                }
            ]
        },
        {
            "metricDescriptor": {
              "name": "node_processes_cpu_usage",
              "description": "Number of processes in each cpu.",
              "type": "GAUGE_DOUBLE",
              "labelKeys": [{
                "key": "process"
              }, {
                "key": "process_id"
              }]
            },
            "timeseries": [{
              "labelValues": [{
                "value": "bash",
                "hasValue": true
              }, {
                "value": "1",
                "hasValue": true
              }],
              "points": [{
                "timestamp": "{{.Timestamp}}",
                "doubleValue": 0.04108750827226494
              }]
            }, {
              "labelValues": [{
                "value": "ss_infra_agent",
                "hasValue": true
              }, {
                "value": "8862",
                "hasValue": true
              }],
              "points": [{
                "timestamp": "{{.Timestamp}}",
                "doubleValue": 0.0
              }]
            }]
          },
          {
            "metricDescriptor": {
              "name": "node_processes_ram_usage",
              "description": "Amount of ram used by each process.",
              "type": "GAUGE_DOUBLE",
              "labelKeys": [{
                "key": "process"
              }, {
                "key": "process_id"
              }]
            },
            "timeseries": [{
              "labelValues": [{
                "value": "bash",
                "hasValue": true
              }, {
                "value": "1",
                "hasValue": true
              }],
              "points": [{
                "timestamp": "{{.Timestamp}}",
                "doubleValue": 1.04108750827226494
              }]
            }, {
              "labelValues": [{
                "value": "ss_infra_agent",
                "hasValue": true
              }, {
                "value": "8862",
                "hasValue": true
              }],
              "points": [{
                "timestamp": "{{.Timestamp}}",
                "doubleValue": 0.0
              }]
            }]
          },

        {
            "metric_descriptor": {
                "name": "node_cpu_usage_per",
                "description": "Avg CPU usage of all the cores",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",
                            "double_value": 11.54328732747727
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_disk_read_bytes_total",
                "description": "The total number of bytes read successfully.",
                "type": "CUMULATIVE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    }
                ]
            },
            "timeseries": [
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "disk0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.6069097472E10
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_disk_written_bytes_total",
                "description": "The total number of bytes written successfully.",
                "type": "CUMULATIVE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    }
                ]
            },
            "timeseries": [
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "disk0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.6069097472E10
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_filesystem_avail_bytes",
                "description": "Filesystem space available to non-root users in bytes.",
                "type": "GAUGE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    },
                    {
                        "key": "fstype"
                    },
                    {
                        "key": "mountpoint"
                    }
                ]
            },
            "timeseries": [
                {
                    "label_values": [
                        {
                            "value": "/Users/nagesh.bs/Downloads/Visual Studio Code.app",
                            "hasValue": true
                        },
                        {
                            "value": "nullfs",
                            "hasValue": true
                        },
                        {
                            "value": "/private/var/folders/zw/rr6l1g0n1zg36d5ysy_gth8nzl30tc/T/AppTranslocation/E3AE8034-2AFA-487A-8A80-1258CAE869DC",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.6069097472E10
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/iSCPreboot",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.04418304E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s2",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/xarts",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.04418304E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s3",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Hardware",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.04418304E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Update/mnt1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.22298298368E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s1s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.222972416E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s2",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Preboot",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.22297204736E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s4",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Update",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.22298298368E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s5",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.222972416E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s6",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/VM",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.22298298368E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "map -fstab",
                            "hasValue": true
                        },
                        {
                            "value": "autofs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data/Network/Servers",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "map auto_home",
                            "hasValue": true
                        },
                        {
                            "value": "autofs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data/home",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_load1",
                "description": "1m load average.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.42626953125
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_load15",
                "description": "15m load average.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.79248046875
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_load5",
                "description": "5m load average.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 3.5947265625
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_filesystem_size_bytes",
                "description": "Filesystem size in -ytes.",
                "type": "GAUGE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    },
                    {
                        "key": "fstype"
                    },
                    {
                        "key": "mountpoint"
                    }
                ]
            },
            "timeseries": [
                {
                    "label_values": [
                        {
                            "value": "/Users/nagesh.bs/Downloads/Visual Studio Code.app",
                            "hasValue": true
                        },
                        {
                            "value": "nullfs",
                            "hasValue": true
                        },
                        {
                            "value": "/private/var/folders/zw/rr6l1g0n1zg36d5ysy_gth8nzl30tc/T/AppTranslocation/E3AE8034-2AFA-487A-8A80-1258CAE869DC",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/iSCPreboot",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.24288E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s2",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/xarts",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.24288E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk1s3",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Hardware",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.24288E8
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Update/mnt1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s1s1",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s2",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Preboot",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s4",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Update",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s5",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "/dev/disk3s6",
                            "hasValue": true
                        },
                        {
                            "value": "apfs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/VM",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.94384795648E11
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "map -fstab",
                            "hasValue": true
                        },
                        {
                            "value": "autofs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data/Network/Servers",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "label_values": [
                        {
                            "value": "map auto_home",
                            "hasValue": true
                        },
                        {
                            "value": "autofs",
                            "hasValue": true
                        },
                        {
                            "value": "/System/Volumes/Data/home",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_memory_MemAvailable_bytes",
                "description": "Memory information field free_bytes.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.53157632E8
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_memory_SwapTotal_bytes",
                "description": "Memory information field swap_total_bytes.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 992628736.0
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_memory_SwapFree_bytes",
                "description": "Memory information field swap_used_bytes.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 992628736.0
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_memory_MemTotal_bytes",
                "description": "Memory information field total_bytes.",
                "type": "GAUGE_DOUBLE"
            },
            "timeseries": [
                {
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1.7179869184E10
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_network_receive_bytes_total",
                "description": "Network device statistic receive_bytes.",
                "type": "CUMULATIVE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    }
                ]
            },
            "timeseries": [
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 992628736.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "ap1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "awdl0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "bridge0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.49880064E8
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en3",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en4",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en5",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en6",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "gif0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "llw0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "lo0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 7.7191168E7
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "stf0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun3",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 5.16929536E8
                        }
                    ]
                }
            ]
        },
        {
            "metric_descriptor": {
                "name": "node_network_transmit_bytes_total",
                "description": "Network device statistic transmit_bytes.",
                "type": "CUMULATIVE_DOUBLE",
                "label_keys": [
                    {
                        "key": "device"
                    }
                ]
            },
            "timeseries": [
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 992628736.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "anpi2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "ap1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 1200128.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "awdl0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "bridge0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 7.29088E7
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en3",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en4",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en5",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "en6",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "gif0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "llw0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "lo0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 7.7191168E7
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "stf0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun0",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun1",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun2",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 0.0
                        }
                    ]
                },
                {
                    "start_timestamp": "{{.Timestamp}}",

                    "label_values": [
                        {
                            "value": "utun3",
                            "hasValue": true
                        }
                    ],
                    "points": [
                        {
                            "timestamp": "{{.Timestamp}}",

                            "double_value": 4.6396416E7
                        }
                    ]
                }
            ]
        }
    ],
    "resource": {
        "labels": {
            "cores": "8",
            "ip": "10.196.189.19,10.87.37.236",
            "hostname": "IN-TC6C23L4W9",
            "kernel": "Darwin",
            "osName": "darwin",
            "os_version": "13.6.2",
            "arch": "arm64",
            "agent_version": "3.0.0"
        }
    }
}]' qa-grpc-collector.133.237.79.36.sslip.io:80

    echo "{\"name\": \"service1$j\"}"
    done
done
